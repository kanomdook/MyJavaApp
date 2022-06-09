package com.sacm.unit.test;

public interface SACMCommand {
	public final class L3IPV4 {
		public final class UGW {
			public static final String FILTER = "filter f-%s-%s l34-protocol any server-ip %s %s";
			public static final String FILTER_GROUP = "filter-group fg-rn-%s filter f-%s-%s";
			public static final String REFRESH = "refresh-service";
			public static final String ERROR = "Error";

		}

		public final class PGW {
			public static final String FILTER = "filter f-%s-%s l34-protocol any server-ip %s %s";
			public static final String FILTER_GROUP = "filter-group fg-rn-%s filter f-%s-%s";
			public static final String REFRESH = "refresh-service";
		}

		public final class vPGW {
			public static final String ADD_FILTER = "ADD FILTER:FILTERNAME=\"f-%s-%s\", L34PROTTYPE=STRING, L34PROTOCOL=ANY, SVRIPMODE=IP, SVRIP=\"%s\", SVRIPMASKTYPE=LENGTHTYPE, SVRIPMASKLEN=%s, MSSTARTPORT=0, MSENDPORT=65535, SVRSTARTPORT=0, SVRENDPORT=65535;";
			public static final String ADD_FLOWFILTER = "ADD FLOWFILTER:FLOWFILTERNAME=\"ff-rn-%s\", TETHERDETFLAG=NONE;";
			public static final String ADD_FLTBINDFLOWF = "ADD FLTBINDFLOWF:FLOWFILTERNAME=\"ff-rn-%s\", FILTERNAME=\"f-%s-%s\";";
			public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
			public static final String ERROR = "Error";
		}

		public final class vGWC {
			public static final String ADD_FILTER = "ADD FILTER:FILTERNAME=\"f-%s-%s\", L34PROTTYPE=STRING, L34PROTOCOL=ANY, SVRIPMODE=IP, SVRIP=\"%s\", SVRIPMASKTYPE=LENGTHTYPE, SVRIPMASKLEN=%s, MSSTARTPORT=0, MSENDPORT=65535, SVRSTARTPORT=0, SVRENDPORT=65535;";
			public static final String ADD_FLOWFILTER = "ADD FLOWFILTER:FLOWFILTERNAME=\"ff-rn-%s\", TETHERDETFLAG=NONE;";
			public static final String ADD_FLTBINDFLOWF = "ADD FLTBINDFLOWF:FLOWFILTERNAME=\"ff-rn-%s\", FILTERNAME=\"f-%s-%s\";";
			public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
			public static final String ERROR = "Error";
		}

		public final class UPF {
			public static final String ADD_FILTER = "ADD FILTER:FILTERNAME=\"f-%s-%s\", L34PROTTYPE=STRING, L34PROTOCOL=ANY, SVRIPMODE=IP, SVRIP=\"%s\", SVRIPMASKTYPE=LENGTHTYPE, SVRIPMASKLEN=%s, MSSTARTPORT=0, MSENDPORT=65535, SVRSTARTPORT=0, SVRENDPORT=65535;";
			public static final String ADD_FLOWFILTER = "ADD FLOWFILTER:FLOWFILTERNAME=\"ff-rn-%s\", TETHERDETFLAG=NONE;";
			public static final String ADD_FLTBINDFLOWF = "ADD FLTBINDFLOWF:FLOWFILTERNAME=\"ff-rn-%s\", FILTERNAME=\"f-%s-%s\";";
			public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
			public static final String ERROR = "Error";
		}

		public final class ZTEvGWU {
			public static final String ADD_L34FILTER = "ADD L34FILTER:FILTERNAME=\"f-%s-%s\",IPTYPE=\"IPV4\",IPV4SERVERIP=\"%s\",IPV4SERVERIPMASK=%s,IPV6SERVERIP=\"::\",IPV6SERVERIPMASK=0,PROTOCOL=\"ANY\",SERVERPORTSTART=0,SERVERPORTEND=0,IPV4MSIP=\"0.0.0.0\",IPV4MSIPMASK=0,IPV6MSIP=\"::\",IPV6MSIPMASK=0,MSPORTSTART=0,MSPORTEND=0;";
			public static final String ADD_L34FILTERGROUP = "ADD L34FILTERGROUP:GROUPNAME=\"fg-rn-%s\",L34FILTERNAME=\"f-%s-%s\";";
			public static final String ADD_FLOWFILTER = "ADD FLOWFILTER:FLOWFILTERNAME=\"ff-rn-%s\",L34FILTERGROUPNAME=\"fg-rn-%s\",PMPATH=\"DEFAULTPATH\",APPFEATURE=\"NOTFREE\";";
			public static final String REFRESH = "DPI RULE REFRESH;";
		}
	}
	public final class L3HOST{
		public final class UGW{
			public static final String HOST = "host h-%s%s domain %s sequence 65535";
			public static final String FILTER_IPV4  = "filter f-%s%s l34-protocol any host h-%s%s";
			public static final String FILTER_IPV6  = "filter f-%s%s-ipv6 ipv6 l34-protocol any host h-%s%s";
			public static final String FILTER_GROUP_IPV4 = "filter-group fg-rn-%s filter f-%s%s";
			public static final String FILTER_GROUP_IPV6 = "filter-group fg-rn-%s filter f-%s%s-ipv6";
			public static final String REFRESH = "refresh-service";
			public static final String ERROR ="Error";

		}
		public final class PGW{
			public static final String HOST = "host h-%s%s domain %s sequence 65535";
			public static final String FILTER_IPV4  = "filter f-%s l34-protocol any host h-%s";
			public static final String FILTER_IPV6  = "filter f-%s-ipv6 ipv6 l34-protocol any host h-%s";
			public static final String FILTER_GROUP_IPV4 = "filter-group fg-rn-%s filter f-%s";
			public static final String FILTER_GROUP_IPV6 = "filter-group fg-rn-%s filter f-%s-ipv6";
			public static final String REFRESH = "refresh-service";
		}
		public final class vPGW{
			public static final String ADD_HOST = "ADD HOST:HOSTNAME=\"h-%s%s\", DOMAINVALUE=\"%s\", PRIORITY=65535;";
			public static final String ADD_FILTER = "ADD FILTER:FILTERNAME=\"f-%s%s\", L34PROTTYPE=STRING, L34PROTOCOL=ANY, SVRIPMODE=HOSTNAME, HOSTNAME=\"h-%s%s\", MSSTARTPORT=0, MSENDPORT=65535, SVRSTARTPORT=0, SVRENDPORT=65535;";
			public static final String ADD_FILTERIPV6 = "ADD FILTERIPV6:FILTERNAME=\"f-%s%s-ipv6\", L34PROTOCOL=ANY, SVRIPMODE=HOSTNAME, HOSTNAME=\"h-%s%s\", MSSTARTPORT=0, MSENDPORT=65535, SVRSTARTPORT=0, SVRENDPORT=65535, L34PROTTYPEV6=STRING;";
			public static final String ADD_FLOWFILTER = "ADD FLOWFILTER:FLOWFILTERNAME=\"ff-rn-%s\", TETHERDETFLAG=NONE;";
			public static final String ADD_L34FILTERGROUP = "ADD FLTBINDFLOWF:FLOWFILTERNAME=\"ff-rn-%s\", FILTERNAME=\"f-%s%s\";";
			public static final String ADD_L34FILTERGROUP_IPV6 = "ADD FLTBINDFLOWF:FLOWFILTERNAME=\"ff-rn-%s\", FILTERNAME=\"f-%s%s-ipv6\";";
			public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
			public static final String ERROR ="Error";
		}
		public final class vGWC{
			public static final String ADD_HOST = "ADD HOST:HOSTNAME=\"h-%s%s\", DOMAINVALUE=\"%s\", PRIORITY=65535;";
			public static final String ADD_FILTER = "ADD FILTER:FILTERNAME=\"f-%s%s\", L34PROTTYPE=STRING, L34PROTOCOL=ANY, SVRIPMODE=HOSTNAME, HOSTNAME=\"h-%s%s\", MSSTARTPORT=0, MSENDPORT=65535, SVRSTARTPORT=0, SVRENDPORT=65535;";
			public static final String ADD_FILTERIPV6 = "ADD FILTERIPV6:FILTERNAME=\"f-%s%s-ipv6\", L34PROTOCOL=ANY, SVRIPMODE=HOSTNAME, HOSTNAME=\"h-%s%s\", MSSTARTPORT=0, MSENDPORT=65535, SVRSTARTPORT=0, SVRENDPORT=65535, L34PROTTYPEV6=STRING;";
			public static final String ADD_FLOWFILTER = "ADD FLOWFILTER:FLOWFILTERNAME=\"ff-rn-%s\", TETHERDETFLAG=NONE;";
			public static final String ADD_L34FILTERGROUP = "ADD FLTBINDFLOWF:FLOWFILTERNAME=\"ff-rn-%s\", FILTERNAME=\"f-%s%s\";";
			public static final String ADD_L34FILTERGROUP_IPV6 = "ADD FLTBINDFLOWF:FLOWFILTERNAME=\"ff-rn-%s\", FILTERNAME=\"f-%s%s-ipv6\";";
			public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
			public static final String ERROR ="Error";
		}
		public final class UPF{
			public static final String ADD_HOST = "ADD HOST:HOSTNAME=\"h-%s%s\", DOMAINVALUE=\"%s\", PRIORITY=65535;";
			public static final String ADD_FILTER = "ADD FILTER:FILTERNAME=\"f-%s%s\", L34PROTTYPE=STRING, L34PROTOCOL=ANY, SVRIPMODE=HOSTNAME, HOSTNAME=\"h-%s%s\", MSSTARTPORT=0, MSENDPORT=65535, SVRSTARTPORT=0, SVRENDPORT=65535;";
			public static final String ADD_FILTERIPV6 = "ADD FILTERIPV6:FILTERNAME=\"f-%s%s-ipv6\", L34PROTOCOL=ANY, SVRIPMODE=HOSTNAME, HOSTNAME=\"h-%s%s\", MSSTARTPORT=0, MSENDPORT=65535, SVRSTARTPORT=0, SVRENDPORT=65535, L34PROTTYPEV6=STRING;";
			public static final String ADD_FLOWFILTER = "ADD FLOWFILTER:FLOWFILTERNAME=\"ff-rn-%s\", TETHERDETFLAG=NONE;";
			public static final String ADD_L34FILTERGROUP = "ADD FLTBINDFLOWF:FLOWFILTERNAME=\"ff-rn-%s\", FILTERNAME=\"f-%s%s\";";
			public static final String ADD_L34FILTERGROUP_IPV6 = "ADD FLTBINDFLOWF:FLOWFILTERNAME=\"ff-rn-%s\", FILTERNAME=\"f-%s%s-ipv6\";";
			public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
			public static final String ERROR ="Error";
		}
		public final class ZTEvGWU{
			public static final String ADD_DOMAIN = "ADD DOMAIN:NAME=\"h-%s%s\",DOMAINVALUE=\"%s\",DOMAINTYPE=\"DEFAULT\";";
			public static final String ADD_L34FILTER = "ADD L34FILTER:FILTERNAME=\"f-%s%s\",IPTYPE=\"IPV4\",IPV4SERVERIP=\"0.0.0.0\",IPV4SERVERIPMASK=0,DOMAIN=\"h-%s%s\",IPV6SERVERIP=\"::\",IPV6SERVERIPMASK=0,PROTOCOL=\"ANY\",SERVERPORTSTART=0,SERVERPORTEND=0,IPV4MSIP=\"0.0.0.0\",IPV4MSIPMASK=0,IPV6MSIP=\"::\",IPV6MSIPMASK=0,MSPORTSTART=0,MSPORTEND=0;";
			public static final String ADD_L34FILTER_IPV6 = "ADD L34FILTER:FILTERNAME=\"f-%s%s-ipv6\",IPTYPE=\"IPV6\",IPV4SERVERIP=\"0.0.0.0\",IPV4SERVERIPMASK=0,DOMAIN=\"h-%s%s\",IPV6SERVERIP=\"::\",IPV6SERVERIPMASK=0,PROTOCOL=\"ANY\",SERVERPORTSTART=0,SERVERPORTEND=0,IPV4MSIP=\"0.0.0.0\",IPV4MSIPMASK=0,IPV6MSIP=\"::\",IPV6MSIPMASK=0,MSPORTSTART=0,MSPORTEND=0;";
			public static final String ADD_L34FILTERGROUP = "ADD L34FILTERGROUP:GROUPNAME=\"fg-rn-%s\",L34FILTERNAME=\"f-%s%s\";";
			public static final String ADD_L34FILTERGROUP_IPV6 = "ADD L34FILTERGROUP:GROUPNAME=\"fg-rn-%s\",L34FILTERNAME=\"f-%s%s-ipv6\";";
			public static final String ADD_FLOWFILTER  = "ADD FLOWFILTER:FLOWFILTERNAME=\"ff-rn-%s\",L34FILTERGROUPNAME=\"fg-rn-%s\",PMPATH=\"DEFAULTPATH\",APPFEATURE=\"NOTFREE\";";
			public static final String REFRESH = "DPI RULE REFRESH;";
		}

	}
	public final class RULEL3{
		public final class ADD_RULE{
			public final class UGW{
				public static final String ADD_RULE1 = "category-group cg-rn-%s-%s category-property qos-%s charge-property cp-%s";
				public static final String ADD_RULE2 = "rule rn-%s-%s-l3 filter-group fg-rn-%s service-category-group cg-rn-%s-%s priority %s";
				public static final String REFRESH = "refresh-service";
			}
			public final class PGW{
				public static final String ADD_RULE1 = "category-group cg-rn-%s-%s category-property qos-%s charge-property cp-%s";
				public static final String ADD_RULE2 = "rule rn-%s-%s-l3 filter-group fg-rn-%s service-category-group cg-rn-%s-%s priority %s";
				public static final String REFRESH = "refresh-service";
			}
			public final class vPGW{
				public static final String ADD_RULE1 = "ADD RULE:RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=PCC, FLOWFILTERNAME=\"ff-rn-%s\", PRIORITY=%s, POLICYNAME=\"pg-%s\", FILTERINGMODE=FLOWFILTER;";
				public static final String ADD_RULE2 = "ADD RULE:RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=BWM, FLOWFILTERNAME=\"ff-rn-%s\", PRIORITY=%s, POLICYNAME=\"qos-%s\", FILTERINGMODE=FLOWFILTER;";
				public static final String BLACKLISTRULE = "ADD BLACKLISTRULE:RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=HEADEN, FLOWFILTERNAME=\"ff-rn-%s\", PRIORITY=%s, FILTERINGMODE=FLOWFILTER;";
				public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
				public static final String ERROR ="Error";
			}
			public final class vGWC{
				public static final String ADD_RULE1 = "ADD RULE:RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=PCC, FLOWFILTERNAME=\"ff-rn-%s\", PRIORITY=%s, POLICYNAME=\"pg-%s\", FILTERINGMODE=FLOWFILTER;";
				public static final String ADD_RULE2 = "ADD RULE:RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=BWM, FLOWFILTERNAME=\"ff-rn-%s\", PRIORITY=%s, POLICYNAME=\"qos-%s\", FILTERINGMODE=FLOWFILTER;";
				public static final String BLACKLISTRULE = "ADD BLACKLISTRULE:RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=HEADEN, FLOWFILTERNAME=\"ff-rn-%s\", PRIORITY=%s, FILTERINGMODE=FLOWFILTER;";
				public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
				public static final String ERROR ="Error";
			}
			public final class SMF{
				public static final String ADD_RULE1 = "ADD RULE:RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=PCC, PRIORITY=%s, POLICYNAME=\"pg-%s\";";
				public static final String ADD_RULE2 = "ADD RULE:RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=BWM, PRIORITY=%s;";
			}
			public final class UPF{
				public static final String ADD_RULE1 = "ADD RULE:RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=PCC, FLOWFILTERNAME=\"ff-rn-%s\", PRIORITY=%s, POLICYNAME=\"pg-%s\", FILTERINGMODE=FLOWFILTER;";
				public static final String ADD_RULE2 = "ADD RULE:RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=BWM, FLOWFILTERNAME=\"ff-rn-%s\", PRIORITY=%s, POLICYNAME=\"qos-%s\", FILTERINGMODE=FLOWFILTER;";
				public static final String BLACKLISTRULE = "ADD BLACKLISTRULE:RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=HEADEN, FLOWFILTERNAME=\"ff-rn-%s\", PRIORITY=%s, FILTERINGMODE=FLOWFILTER;";
				public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
			}
			public final class ZTEvGWU{
				public static final String ADD_RULE1 = "ADD RULE:NAME=\"rn-%s-%s-l3\",FLOWFILTER=\"ff-%s\",QOSDATA=\"qos-%s\",CHARGINGDATA=\"cg-%s\",TRAFFICCONTROLDATA=\"tc-default\",MONITORURRID=0,PRECEDENCE=%s,TETHERINGFLAG=\"DEFAULT\";";
				public static final String REFRESH = "DPI RULE REFRESH;";
			}
		}
		public final class ADD_RBN{
			public final class UGW{
				public static final String ADD_RBN1 = "user-profile rbn-%s-%s";
				public static final String ADD_RBN2 = "rule-binding rn-%s-%s-l3 priority %s";
				public static final String QUIT = "quit";
				public static final String REFRESH = "refresh-service";
				public static final String ERROR ="Error";

			}
			public final class PGW{
				public static final String ADD_RBN1 = "user-profile rbn-%s-%s";
				public static final String ADD_RBN2 = "rule-binding rn-%s-%s-l3 priority %s";
				public static final String QUIT = "quit";
				public static final String REFRESH = "refresh-service";
			}
			public final class vPGW{
				public static final String ADD_RBN = "ADD USERPROFILE:USERPROFILENAME= \"rbn-%s-1m\",ALIASMARKFLAG=DISABLE,DDOSCHECK=DISABLE,CAPMODETHRES=0,QUOTAAPPACTTYPE=BUFFER,FREESERONLCHG=ENABLE,FREESEROFFCHG=ENABLE,LOCRPTSWITCH=INHERIT,MONITORINGKEY=4294967295,TETHERINGMAXNUM=0,TETHERINGCTRL=ALL_TERMINAL;";
				public static final String SET_RBN_USER = "SET USERPROFILELOCK:USERPROFILENAME=\"rbn-%s-1m\",LOCKFLAG=DISABLE;";
				public static final String ADD_RBN_PCC = "ADD RULEBINDING:USERPROFILENAME=\"rbn-%s-1m\",RULENAME=\"rn-%s-%s-l3\",POLICYTYPE=PCC,PRIORITY=%s;";
				public static final String ADD_RBN_BWM = "ADD RULEBINDING:USERPROFILENAME=\"rbn-%s-1m\",RULENAME=\"rn-%s-%s-l3\",POLICYTYPE=BWM,PRIORITY=%s;";
				public static final String ADD_RBN_USER = "ADD RULEBINDING:USERPROFILENAME=\"rbn-%s-1m\",RULENAME=\"rn-%s-%s-l3\",POLICYTYPE=HEADEN,PRIORITY=%s;";
				public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
				public static final String ERROR ="Error";
			}
			public final class vGWC{
				public static final String ADD_RBN = "ADD USERPROFILE:USERPROFILENAME= \"rbn-%s-1m\",ALIASMARKFLAG=DISABLE,DDOSCHECK=DISABLE,CAPMODETHRES=0,QUOTAAPPACTTYPE=BUFFER,FREESERONLCHG=ENABLE,FREESEROFFCHG=ENABLE,LOCRPTSWITCH=INHERIT,MONITORINGKEY=4294967295,TETHERINGMAXNUM=0,TETHERINGCTRL=ALL_TERMINAL;";
				public static final String SET_RBN_USER = "SET USERPROFILELOCK:USERPROFILENAME=\"rbn-%s-1m\",LOCKFLAG=DISABLE;";
				public static final String ADD_RBN_PCC = "ADD RULEBINDING:USERPROFILENAME=\"rbn-%s-1m\",RULENAME=\"rn-%s-%s-l3\",POLICYTYPE=PCC,PRIORITY=%s;";
				public static final String ADD_RBN_BWM = "ADD RULEBINDING:USERPROFILENAME=\"rbn-%s-1m\",RULENAME=\"rn-%s-%s-l3\",POLICYTYPE=BWM,PRIORITY=%s;";
				public static final String ADD_RBN_USER = "ADD RULEBINDING:USERPROFILENAME=\"rbn-%s-1m\",RULENAME=\"rn-%s-%s-l3\",POLICYTYPE=HEADEN,PRIORITY=%s;";
				public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
				public static final String ERROR ="Error";
			}
			public final class SMF{
				public static final String ADD_RBN = "ADD USERPROFILE:USERPROFILENAME=\"rbn-%s-1m\", FREESERONLCHG=ENABLE, FREESEROFFCHG=ENABLE, UPTYPE=PCC;";
				public static final String SET_RBN_USER = "SET USERPROFILELOCK:USERPROFILENAME=\"rbn-%s-1m\", LOCKFLAG=DISABLE;";
				public static final String ADD_RBN_USER = "ADD RULEBINDING:USERPROFILENAME=\"rbn-%s-1m\", RULENAME=\"rn-%s-%s-l3\";";
				public static final String ERROR ="Error";
			}
			public final class UPF{
				public static final String ADD_RBN = "ADD USERPROFILE:USERPROFILENAME=\"rbn-%s-1m\", ALIASMARKFLAG=DISABLE, DDOSCHECK=DISABLE, CAPMODETHRES=0, LOCRPTSWITCH=INHERIT, TETHERINGMAXNUM=0;";
				public static final String LCK_USER = "LCK USERPROFILE:USERPROFILENAME=\"rbn-%s-1m\", LOCKFLAG=DISABLE;";
				public static final String ADD_RBN_PCC = "ADD RULEBINDING:USERPROFILENAME=\"rbn-%s-1m\", RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=PCC;";
				public static final String ADD_RBN_BWM = "ADD RULEBINDING:USERPROFILENAME=\"rbn-%s-1m\", RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=BWM;";
				public static final String ADD_RBN_HEADEN = "ADD RULEBINDING:USERPROFILENAME=\"rbn-%s-1m\", RULENAME=\"rn-%s-%s-l3\", POLICYTYPE=HEADEN;";
				public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
				public static final String ERROR ="Error";
			}
			public final class ZTEvGWU{
				public static final String ADD_USER = "ADD USERPROFILE:NAME=\"rbn-%s-1m\",USERPROFILETYPE=\"PREDEFINED_RULE_GROUP\",PRECEDENCE=4294967295,DPIUPCONFIG=\"default\",TETHERINGFLAG=\"DEFAULT\";	";
				public static final String ADD_RBN = "ADD RULEBINDUP:UPNAME=\"rbn-%s-1m\",RULENAME=\"rn-%s-%s-l3\",PRECEDENCE=%s;";
				public static final String REFRESH = "DPI RULE REFRESH;";
			}
		}	
	}
	public final class NEWRG{
		public final class SMF{
			public static final String ADD_RG1 = "ADD URR:URRNAME=\"urrid-%s-online\" ,URRID=%s, USAGERPTMODE=ONLINE, ONLCOMPOUNDTYPE=RGSID, ONLINERG=%s ,ONLINESID=%s, ONLMETERINGTYPE=VOLUME, VOLUMERSUVALUE=0;";
			public static final String ADD_RG2 = "ADD URRGROUP:URRGROUPNAME=\"urrg-%s\", UPURRNAME1=\"urrid-%s-online\", DOWNURRNAME1=\"urrid-%s-online\", NOCHARGINGFLAG=NONE;";
			public static final String ADD_RG3 = "ADD PCCPOLICYGRP:PCCPOLICYGRPNM=\"pg-%s\", URRGROUPNAME=\"urrg-%s\", FUPSESSIONEXC=DISABLE;";
			public static final String ERROR ="Error";
		}
		public final class UPF{
			public static final String ADD_RG1 = "ADD URR:URRNAME=\"urrid-%s-online\" ,URRID=%s, USAGERPTMODE=ONLINE, ONLMETERINGTYPE=VOLUME;";
			public static final String ADD_RG2 = "ADD URRGROUP:URRGROUPNAME=\"urrg-%s\", UPURRNAME1=\"urrid-%s-online\", DOWNURRNAME1=\"urrid-%s-online\", NOCHARGINGFLAG=NONE;";
			public static final String ADD_RG3 = "ADD PCCPOLICYGRP:PCCPOLICYGRPNM=\"pg-%s\", FUPSESSIONEXC=DISABLE, SIGNALASSOCIATE=ENABLE, ADCMUTEFLAG=ENABLE, HTTP2DEGRADESW=INHERIT, TOKENFUNCFLAG=DISABLE, URRGROUPNAME=\"urrg-%s\";";
			public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
			public static final String ERROR ="Error";
		}
		public final class vPGW{
			public static final String ADD_RG1 = "ADD CBBID:CBBIDNAME=\"cbbid-%s-offline\",CHARGINGMODE=OFFLINE,OFFCOMPOUNDTYPE=RGSID,RG=%s,SID=%s,OFFMETERINGTYPE=VOLUME;";
			public static final String ADD_RG2 = "ADD CBBID:CBBIDNAME=\"cbbid-%s-online\",CHARGINGMODE=ONLINE,ONLCOMPOUNDTYPE=RGSID,ONLINERG=%s,ONLINESID=%s,ONLMETERINGTYPE=VOLUME,VOLUMERSUVALUE=0;";
			public static final String ADD_RG3 = "ADD CHARGEPROP:CHARGEPROPNAME=\"cp-%s\",UPCBBIDNAME=\"cbbid-%s-offline\",DOWNCBBIDNAME=\"cbbid-%s-offline\",ONLUPCBBIDNAME=\"cbbid-%s-online\",ONLDNCBBIDNAME=\"cbbid-%s-online\",NOCHARGINGFLAG=NONE;";
			public static final String ADD_RG4 = "ADD PCCPOLICYGRP:PCCPOLICYGRPNM=\"pg-%s\",CHARGEPROPNAME=\"cp-%s\",FUPSESSIONEXC=DISABLE,TOKENFUNCFLAG=DISABLE,SIGNALASSOCIATE=ENABLE,ADCMUTEFLAG=ENABLE,HTTP2DEGRADESW=INHERIT,EVENTCHARGEFLAG=DISABLE,EVENTCHGPOINT=RESPONSE,MMSCHARGETYPE=SINGLE;";
			public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
			public static final String ERROR ="Error";
		}
		public final class vGWC{
			public static final String ADD_RG1 = "ADD CBBID:CBBIDNAME=\"cbbid-%s-offline\",CHARGINGMODE=OFFLINE,OFFCOMPOUNDTYPE=RGSID,RG=%s,SID=%s,OFFMETERINGTYPE=VOLUME;";
			public static final String ADD_RG2 = "ADD CBBID:CBBIDNAME=\"cbbid-%s-online\",CHARGINGMODE=ONLINE,ONLCOMPOUNDTYPE=RGSID,ONLINERG=%s,ONLINESID=%s,ONLMETERINGTYPE=VOLUME,VOLUMERSUVALUE=0;";
			public static final String ADD_RG3 = "ADD CHARGEPROP:CHARGEPROPNAME=\"cp-%s\",UPCBBIDNAME=\"cbbid-%s-offline\",DOWNCBBIDNAME=\"cbbid-%s-offline\",ONLUPCBBIDNAME=\"cbbid-%s-online\",ONLDNCBBIDNAME=\"cbbid-%s-online\",NOCHARGINGFLAG=NONE;";
			public static final String ADD_RG4 = "ADD PCCPOLICYGRP:PCCPOLICYGRPNM=\"pg-%s\",CHARGEPROPNAME=\"cp-%s\",FUPSESSIONEXC=DISABLE,TOKENFUNCFLAG=DISABLE,SIGNALASSOCIATE=ENABLE,ADCMUTEFLAG=ENABLE,HTTP2DEGRADESW=INHERIT,EVENTCHARGEFLAG=DISABLE,EVENTCHGPOINT=RESPONSE,MMSCHARGETYPE=SINGLE;";
			public static final String REFRESH = "SET REFRESHSRV:REFRESHTYPE=ALL;";
			public static final String ERROR ="Error";
		}
		public final class UGW{
			public static final String ADD_RG1 = "cbb-id cbbid-%s-offline charge-method offline rg %s sid %s metering volume";
			public static final String ADD_RG2 = "cbb-id cbbid-%s-online charge-method online rg %s sid %s metering volume";
			public static final String ADD_RG3 = "charge-property cp-%s up-initial offline cbbid-%s-offline online cbbid-%s-online down-initial offline cbbid-%s-offline online cbbid-%s-online";
			public static final String REFRESH = "refresh-service";
		}
		public final class PGW{
			public static final String ADD_RG1 = "cbb-id cbbid-%s-offline charge-method offline rg %s sid %s metering volume";
			public static final String ADD_RG2 = "cbb-id cbbid-%s-online charge-method online rg %s sid %s metering volume";
			public static final String ADD_RG3 = "charge-property cp-%s up-initial offline cbbid-%s-offline online cbbid-%s-online down-initial offline cbbid-%s-offline online cbbid-%s-online";
			public static final String REFRESH = "refresh-service";
		}
		public final class ZTEvGWC{
			public static final String ADD_RG1 = "ADD URRMAP:URRID=10%s,TYPE=\"OFFLINECHARGESERVICE\",SERVICEID=%s,RATINGGROUP=%s;";
			public static final String ADD_RG2 = "ADD URRMAP:URRID=20%s,TYPE=\"ONLINECHARGESERVICE\",SERVICEID=%s,RATINGGROUP=%s;";
		}
		public final class ZTEvGWU{
			public static final String ADD_RG1 = "ADD URRMAP:URRID=10%s,TYPE=\"OFFLINECHARGESERVICE\",SERVICEID=%s,RATINGGROUP=%s;";
			public static final String ADD_RG2 = "ADD URRMAP:URRID=20%s,TYPE=\"ONLINECHARGESERVICE\",SERVICEID=%s,RATINGGROUP=%s;";
			public static final String ADD_RG3 = "ADD CHARGINGDATA:NAME=\"cg-%s\",OFFLINEURRID=10%s,ONLINEURRID=20%s,FREE=\"false\",NEWPACKETPOLICY=\"DROP\",NEWPACKETQUOTA=2000000,OUTPUTCONBILL=\"ENABLE\";";
			public static final String REFRESH = "DPI RULE REFRESH;";
		}
	}
	
}
