package com.dookdev.init;

import org.apache.commons.lang3.ArrayUtils;

public class EX11 {

	public static void main(String[] args) {
		String title2 = "AWN Access Site";
		String detectDesc = "WNLDT|1|SitePriority=3(MBB-3)";
		System.out.println(">>> TTMDM --> insertTT: oldTitle2: " + title2);
		System.out.println(">>> TTMDM --> insertTT: oldDetectDesc: " + detectDesc);
		if (detectDesc != null && !detectDesc.isEmpty()) {
			if (detectDesc.contains("SitePriority=")) {
				System.out.println(">>> TTMDM --> insertTT: detectDesc have SitePriority");
				String[] splitData = detectDesc.split("\\|", -1);
				if (splitData.length >= 3) {
					String sitePriorityStr = splitData[2];
					System.out.println(">>> TTMDM --> insertTT: sitePriorityStr: " + sitePriorityStr);
					if (sitePriorityStr.contains("SitePriority=")) {
						String newTitle2 = sitePriorityStr + "|" + title2;
						System.out.println(">>> TTMDM --> insertTT: newTitle2: " + newTitle2);
						String[] modArr = ArrayUtils.remove(splitData, 2);
						String newDetectDesc = String.join("|", modArr);
						System.out.println(">>> TTMDM --> insertTT: newDetectDesc: " + newDetectDesc);
					} else {
						System.out.println(">>> TTMDM --> insertTT: found detectDesc is invalid format SitePriority");
					}
				}
			}
		}

	}

}
