package com.dookdev.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;


public class EX10 {
	public static final String STATUS = "STATUS";
	public static final String STATUS_ERROR = "STATUS ERROR";
	public static final String ERROR_MESSAGE = "ERROR MESSAGE";
	public static final String STATUS_SUCCESS = "STATUS SUCCESS";
	public static final String RESULT = "RESULT";
	public static final String ERROR_EXCEPTION = "ERROR EXCEPTION";
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String dbUrl = "jdbc:postgresql://10.138.36.222:5432/almgw";
			String username = "almgwuser";
			String password = "almgwuser123";
			String ssl = "false";
			Class.forName("org.postgresql.Driver");
			Properties props = new Properties();
			props.setProperty("user", username);
			props.setProperty("password", password);
			props.setProperty("ssl", ssl);
			conn = DriverManager.getConnection(dbUrl, props);
			System.out.println(">>> resultMap: " + getSitePriority(conn, 1, "GBHSM"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("*** close connection success");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	public static HashMap<String, String> getSitePriority(Connection conn, Integer userId, String siteCode) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		int maxRange = 5;
		boolean isInvalidRange = false;
		boolean isDuplicate = false;
		String firstPriority = "";
		
		try {
			System.out.println(">>> siteCode: " + siteCode);
			
			if (siteCode == null || siteCode.isEmpty()) {
				resultMap.put(STATUS, STATUS_ERROR);
				resultMap.put(ERROR_MESSAGE, "siteCode is not null or empty");
				return resultMap;
			}
			String sql = "select source_type , site_priority from master.sitepriority where site_code = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, siteCode);
			ResultSet rs = pstmt.executeQuery();

			ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
			
			while (rs.next()) {
				HashMap<String, String> result = new HashMap<String, String>();
				result.put("SOURCE_TYPE", rs.getString("SOURCE_TYPE") == null ? "" : rs.getString("SOURCE_TYPE"));
				result.put("SITE_PRIORITY", rs.getString("SITE_PRIORITY") == null ? "" : rs.getString("SITE_PRIORITY"));
				dataList.add(result);
			}
			
			System.out.println(">>> dataList size: " + dataList.size());

			if (dataList.size() <= 0) {
				resultMap.put(STATUS, STATUS_SUCCESS);
				resultMap.put(RESULT, "{Not Found site code}");
			}

			ArrayList<String> sortDataList = new ArrayList<String>();

			for (int i = 0; i < dataList.size(); i++) {
				HashMap<String, String> data = dataList.get(i);
				sortDataList.add(data.get("SITE_PRIORITY") + "-" + data.get("SOURCE_TYPE"));
			}
			Collections.sort(sortDataList);
			
			System.out.println(">>> sortDataList: " + sortDataList);
			String[] spData = sortDataList.get(0).split("-");
			if(spData.length > 0) {
				firstPriority = spData[0];
			}
			
			System.out.println(">>> firstPriority: " + firstPriority);

			ArrayList<String> inValidRangeData = new ArrayList<String>();

			for (int i = 0; i < dataList.size(); i++) {
				HashMap<String, String> data = dataList.get(i);
				String sourceType = data.get("SOURCE_TYPE");
				String sitePriority = data.get("SITE_PRIORITY");
				String concatStr = sitePriority + "-" + sourceType;
				if (!sitePriority.isEmpty()) {
					int sitePriorityInt = Integer.parseInt(data.get("SITE_PRIORITY"));
					if (sitePriorityInt > maxRange) {
						isInvalidRange = true;
						inValidRangeData.add(concatStr);
					}
				}
			}
			
			System.out.println(">>> isInvalidRange: " + isInvalidRange);

			if (isInvalidRange) {
				System.out.println(">>> inValidRangeData: " + inValidRangeData);
				for (int i = 0; i < inValidRangeData.size(); i++) {
					String ivd = inValidRangeData.get(i);
					for (int j = 0; j < sortDataList.size(); j++) {
						String sd = sortDataList.get(j);
						if(ivd.equalsIgnoreCase(sd)) {
							sortDataList.remove(j);
						}
					}
				}
				System.out.println(">>> final sortDataList: " + sortDataList);
				resultMap.put(STATUS, STATUS_SUCCESS);
				resultMap.put(RESULT, getSitePriorityFormat(firstPriority, sortDataList)+"{Found out of range "+getSourceTypeList(inValidRangeData)+"}");
				return resultMap;
			}
			
			ArrayList<String> duplicateData = new ArrayList<String>();
			
			for (int i = 0; i < sortDataList.size(); i++) {
				String sd = sortDataList.get(i);
				List<String> filterData = sortDataList.stream()
					    .filter(p -> p.equalsIgnoreCase(sd)).collect(Collectors.toList());
				if(filterData.size() > 1) {
					isDuplicate = true;
					for (int j = 0; j < filterData.size(); j++) {
						String data = filterData.get(j);
						if(duplicateData.indexOf(data) <= -1) {
							duplicateData.add(data);
						}
					}
				}
			}
			
			System.out.println(">>> isDuplicate: " + isDuplicate);
			
			if(isDuplicate) {
				System.out.println(">>> duplicateData: " + duplicateData);
				resultMap.put(STATUS, STATUS_SUCCESS);
				resultMap.put(RESULT, getSitePriorityFormat(firstPriority, sortDataList)+"{Found duplicate "+getSourceTypeList(duplicateData)+"}");
				return resultMap;
			}
			
			resultMap.put(STATUS, STATUS_SUCCESS);
			resultMap.put(RESULT, getSitePriorityFormat(firstPriority, sortDataList));

		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put(STATUS, STATUS_ERROR);
			resultMap.put(ERROR_EXCEPTION, e.toString());
			resultMap.put(ERROR_MESSAGE, "");
		}
		return resultMap;
	}
	
	public static String getSitePriorityFormat(String firstPriority, ArrayList<String> dataList) {
		String result = "";
		try {
			List<String> arr = new ArrayList<String>();
			for (int i = 0; i < dataList.size(); i++) {
				String data = dataList.get(i);
				String[] sp = data.split("-");
				if(sp.length >=2) {
					String sitePriority = sp[0];
					String sourceType = sp[1];
					arr.add(sourceType+"-"+sitePriority);
				}
			}
			arr = arr.stream()
				     .distinct()
				     .collect(Collectors.toList());
			result = firstPriority+"("+String.join(",", arr)+")";
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public static List<String> getSourceTypeList(ArrayList<String> dataList){
		List<String> result = new ArrayList<String>();
		try {
			for (int i = 0; i < dataList.size(); i++) {
				String data = dataList.get(i);
				String[] sp = data.split("-");
				if(sp.length >=2) {
					String sourceType = sp[1];
					result.add(sourceType);
				}
			}
			result = result.stream()
		     .distinct()
		     .collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
