package com.boyitech.logstream.server.worker.indexer;

import com.boyitech.logstream.core.info.Event;
import com.boyitech.logstream.core.worker.indexer.BaseIndexer;
import com.boyitech.logstream.core.worker.indexer.BaseIndexerConfig;
import com.boyitech.logstream.worker.indexer.EisooNetworkDiskV1Indexer;
import com.boyitech.logstream.worker.indexer.SangforFirewallAllV1Indexer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author juzheng
 * @Title: IndexerSingleTest
 * @date 2019/7/9 10:55 AM
 * @Description: 对单条日志进行测试的测试类, 可根据需求修改
 */
public class IndexerSingleTest {
    private BaseIndexer Indexer;

    @Before
    public void InitIndexer() {
        System.out.println("---初始化---");
        Map<String, String> map = new HashMap();
        map.put("logType", "1");
        BaseIndexerConfig baseIndexerConfig = new BaseIndexerConfig(map);
        //1.此处修改Indexer类型：如ApacheSuccessIndexer
        Indexer = new EisooNetworkDiskV1Indexer(baseIndexerConfig);
        Indexer.register();
    }

    @Test
    public void indexerSingle() {
        System.out.println("---执行Indexer的测试---");
        List<String> testList = new ArrayList<String>();
        // testList.add("[Sat Dec 01 11:58:28 2018] [error] [client 219.220.243.129] File does not exist: /opt/apache/htdocs/sbs_edu.sql, referer: http://zp.sbs.edu.cn/sbs_edu.sql\n");
        //  testList.add("172.100.48.166 - - [01/Dec/2018:08:04:20 +0800] \"GET /epstar/login/index.jsp HTTP/1.1\" 200 5874\n");
        // testList.add("id=ArrayOS time=\"2019-1-1 09:48:02\" timezone=CST(+0800) fw=AN pri=6 vpn=sslvpn user=17201040211 proto=HTTP src=172.16.100.143 sport=65428 dst=117.185.117.196 dport=80 type=vpn msg=\"TCP connection setup\"\u0000\n");
        //     testList.add("\"<158>LEEF:1.0|Asiainfo security|TDA|3.83.1023|SECURITY_RISK_DETECTION|devTimeFormat=MMM dd yyyy HH:mm:ss z\tptype=IDS\tdvc=190.1.10.250\tdeviceMacAddress=F0:1F:AF:D6:01:15\tdvchost=localhost\tdeviceGUID=4B66BA270A96-44B28094-FE53-C2E3-4D44\tdevTime=Jan 01 2019 08:30:48 GMT+08:00\tsev=2\tprotoGroup=DNS Response\tproto=DNS Response\tvLANId=4095\tdeviceDirection=0\tdhost=localhost\tdst=172.16.200.52\tdstPort=53738\tdstMAC=00:00:0c:07:ac:08\tshost=ca2.sh.cncnet.net\tsrc=210.22.84.3\tsrcPort=53\tsrcMAC=00:1c:7f:57:11:25\tmalType=MALWARE\tfileType=-65536\tfsize=0\truleId=101\tmsg=DNS response resolves to dead IP address\tdeviceRiskConfidenceLevel=2\tbotUrl=0001\tpComp=NCIE\triskType=1\tsrcZone=0\tdstGroup=new office server\tdstZone=1\tdetectionType=1\tact=not blocked\tthreatType=2\tinterestedIp=172.16.200.52\tpeerIp=210.22.84.3\thostName=xfstat.qq.com\tcnt=1\taggregatedCnt=1\tevtCat=Suspicious Traffic\tevtSubCat=DNS\taptRelated=0");
        //  testList.add("<187>May 10 fds22:23:22 2000 H3C %%10IFNET/3/LINK_UPDOWN(l): GigabitEthernet1/0/20 link status is DOWN.");
        // testList.add("172.16.100.23 - - [04/Dec/2018:16:09:21 +0800] \"GET /epstar/web/applications/HRMS/NDKHGL/KHSZ/client/UserWindow.js HTTP/1.1\" 404 118");
        // testList.add("2015-06-27 00:32:29 192.168.70.12 GET /favicon.ico - 80 - 116.226.249.231 Mozilla/5.0+(Windows+NT+5.1)+AppleWebKit/537.36+(KHTML,+like+Gecko)+Chrome/31.0.1650.63+Safari/537.36 200 0 0 15");
        // testList.add("<129>WAF Dec03 16:32:04:ALERT#WAFSPLIT#WAF0HW0CB507#WAFSPLIT#2018-12-3 16:32:4#WAFSPLIT#219.220.248.241#WAFSPLIT#58698#WAFSPLIT#219.220.243.191#WAFSPLIT#80#WAFSPLIT#发现Perl脚本工具提交数据#WAFSPLIT#扫描行为#WAFSPLIT#低#WAFSPLIT#发现Perl脚本工具提交数据#WAFSPLIT#暂无解决方案，建议使用本设备进行防护。#WAFSPLIT#检测#WAFSPLIT#GET#WAFSPLIT#http://219.220.243.191/TSDW/img/6_110_8.png");
        //  testList.add("<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Service Control Manager' Guid='{555908d1-a6d7-4695-8e1e-26931d2012f4}' EventSourceName='Service Control Manager'/><EventID Qualifiers='16384'>7040</EventID><Version>0</Version><Level>4</Level><Task>0</Task><Opcode>0</Opcode><Keywords>0x8080000000000000</Keywords><TimeCreated SystemTime='2019-10-28T07:44:09.863136500Z'/><EventRecordID>6845</EventRecordID><Correlation/><Execution ProcessID='776' ThreadID='1440'/><Channel>System</Channel><Computer>DESKTOP-HP053UI</Computer><Security UserID='S-1-5-18'/></System><EventData><Data Name='param1'>Background Intelligent Transfer Service</Data><Data Name='param2'>自动启动</Data><Data Name='param3'>按需启动</Data><Data Name='param4'>BITS</Data></EventData><RenderingInfo Culture='zh-CN'><Message>Background Intelligent Transfer Service 服务的启动类型从 自动启动 更改为 按需启动。</Message><Level>信息</Level><Task></Task><Opcode></Opcode><Channel></Channel><Provider>Microsoft-Windows-Service Control Manager</Provider><Keywords><Keyword>经典</Keyword></Keywords></RenderingInfo></Event>");
        //testList.add("<129>WAF Aug13 09:48:57:ALERT#WAFSPLIT#WAF0HW0CB507#WAFSPLIT#2015-8-13 9:48:57#WAFSPLIT#124.116.244.199#WAFSPLIT#45590#WAFSPLIT#219.220.243.129#WAFSPLIT#80#WAFSPLIT#发现菜刀通信行为#WAFSPLIT#脚本木马#WAFSPLIT#高#WAFSPLIT#防止ASP一句话木马通信\\\\r\\\\n中国菜刀(China chopper)连接的ASP一句话木马的一般格式为：eval request(\\\\\\\"pass\\\\\\\")，黑客通过Web方式提交恶意代码控制网站服务器，包括上传/下载文件、查看数据库、执行任意命\\\\xE4\\\\xBB1. 根据入侵记录的URL，查找和删除对应的Webshell文件；\\\\r\\\\n2. 对网站进行全面检查，清理后门，修补漏洞；\\\\r\\\\n3. 配置网站时可写的目录不要赋予执行权限，可执行的目录不要赋予写入权限。#WAFSPLIT#1. 根据入侵记录的URL，查找和删除对应的Webshell文件；\\\\r\\\\n2. 对网站进行全面检查，清理后门，修补漏洞；\\\\r\\\\n3. 配置网站时可写的目录不要赋予执行权限，可执行的目录不要赋予写入权限。#WAFSPLIT#阻断#WAFSPLIT#POST#WAFSPLIT#http://zsw.sbs.edu.cn//admin/Admin_Ta.asp");
        //testList.add("<129>WAF Dec03 20:58:53:ALERT#WAFSPLIT#WAF0HW0CB507#WAFSPLIT#2018-12-3 20:58:53#WAFSPLIT#219.220.248.241#WAFSPLIT#58827#WAFSPLIT#219.220.243.191#WAFSPLIT#80#WAFSPLIT#发现Perl脚本工具提交数据#WAFSPLIT#扫描行为#WAFSPLIT#低#WAFSPLIT#发现Perl脚本工具提交数据#WAFSPLIT#暂无解决方案，建议使用本设备进行防护。#WAFSPLIT#检测#WAFSPLIT#GET#WAFSPLIT#http://219.220.243.191/TSDW/img/6_19.5_8.png");
//        testList.add("<129>WAF Dec03 16:59:00:ALERT#WAFSPLIT#WAF0HW0CB507#WAFSPLIT#2018-12-3 16:59:0#WAFSPLIT#27.19.41.194#WAFSPLIT#25697#WAFSPLIT#219.220.243.67#WAFSPLIT#80#WAFSPLIT#发现Python脚本工具提交数据#WAFSPLIT#扫描行为#WAFSPLIT#低#WAFSPLIT#发现Python脚本工具提交数据#WAFSPLIT#暂无解决方案，建议使用本设备进行防护。#WAFSPLIT#检测#WAFSPLIT#GET#WAFSPLIT#http://www.sbs.edu.cn/pjb/gjyj/201701/W020170112552579530835.pdf");
        //testList.add("<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-Security-Auditing' Guid='{54849625-5478-4994-a5ba-3e3b0328c30d}'/><EventID>4625</EventID><Version>2</Version><Level>0</Level><Task>12544</Task><Opcode>0</Opcode><Keywords>0x8020000000000000</Keywords><TimeCreated SystemTime='2019-11-01T02:11:21.789455100Z'/><EventRecordID>43136</EventRecordID><Correlation ActivityID='{bd6e9197-82f4-0002-1892-6ebdf482d501}'/><Execution ProcessID='816' ThreadID='11508'/><Channel>Security</Channel><Computer>DESKTOP-HP053UI</Computer><Security/></System><EventData><Data Name='SubjectUserSid'>S-1-5-18</Data><Data Name='SubjectUserName'>DESKTOP-HP053UI$</Data><Data Name='SubjectDomainName'>WORKGROUP</Data><Data Name='SubjectLogonId'>0x3e7</Data><Data Name='TargetUserSid'>S-1-5-18</Data><Data Name='TargetUserName'>SYSTEM</Data><Data Name='TargetDomainName'>NT AUTHORITY</Data><Data Name='TargetLogonId'>0x3e7</Data><Data Name='LogonType'>5</Data><Data Name='LogonProcessName'>Advapi  </Data><Data Name='AuthenticationPackageName'>Negotiate</Data><Data Name='WorkstationName'>-</Data><Data Name='LogonGuid'>{00000000-0000-0000-0000-000000000000}</Data><Data Name='TransmittedServices'>-</Data><Data Name='LmPackageName'>-</Data><Data Name='KeyLength'>0</Data><Data Name='ProcessId'>0x308</Data><Data Name='ProcessName'>C:\\\\\\\\Windows\\\\\\\\System32\\\\\\\\services.exe</Data><Data Name='IpAddress'>-</Data><Data Name='IpPort'>-</Data><Data Name='ImpersonationLevel'>%%1833</Data><Data Name='RestrictedAdminMode'>-</Data><Data Name='TargetOutboundUserName'>-</Data><Data Name='TargetOutboundDomainName'>-</Data><Data Name='VirtualAccount'>%%1843</Data><Data Name='TargetLinkedLogonId'>0x0</Data><Data Name='ElevatedToken'>%%1842</Data></EventData><RenderingInfo Culture='zh-CN'><Message>已成功登录帐户。\\\\r\\\\n\\\\r\\\\n使用者:\\\\r\\\\n\\\\t安全 ID:\\\\t\\\\tS-1-5-18\\\\r\\\\n\\\\t帐户名称:\\\\t\\\\tDESKTOP-HP053UI$\\\\r\\\\n\\\\t帐户域:\\\\t\\\\tWORKGROUP\\\\r\\\\n\\\\t登录 ID:\\\\t\\\\t0x3E7\\\\r\\\\n\\\\r\\\\n登录信息:\\\\r\\\\n\\\\t登录类型:\\\\t\\\\t5\\\\r\\\\n\\\\t受限制的管理员模式:\\\\t-\\\\r\\\\n\\\\t虚拟帐户:\\\\t\\\\t否\\\\r\\\\n\\\\t提升的令牌:\\\\t\\\\t是\\\\r\\\\n\\\\r\\\\n模拟级别:\\\\t\\\\t模拟\\\\r\\\\n\\\\r\\\\n新登录:\\\\r\\\\n\\\\t安全 ID:\\\\t\\\\tS-1-5-18\\\\r\\\\n\\\\t帐户名称:\\\\t\\\\tSYSTEM\\\\r\\\\n\\\\t帐户域:\\\\t\\\\tNT AUTHORITY\\\\r\\\\n\\\\t登录 ID:\\\\t\\\\t0x3E7\\\\r\\\\n\\\\t链接的登录 ID:\\\\t\\\\t0x0\\\\r\\\\n\\\\t网络帐户名称:\\\\t-\\\\r\\\\n\\\\t网络帐户域:\\\\t-\\\\r\\\\n\\\\t登录 GUID:\\\\t\\\\t{00000000-0000-0000-0000-000000000000}\\\\r\\\\n\\\\r\\\\n进程信息:\\\\r\\\\n\\\\t进程 ID:\\\\t\\\\t0x308\\\\r\\\\n\\\\t进程名称:\\\\t\\\\tC:\\\\\\\\Windows\\\\\\\\System32\\\\\\\\services.exe\\\\r\\\\n\\\\r\\\\n网络信息:\\\\r\\\\n\\\\t工作站名称:\\\\t-\\\\r\\\\n\\\\t源网络地址:\\\\t-\\\\r\\\\n\\\\t源端口:\\\\t\\\\t-\\\\r\\\\n\\\\r\\\\n详细的身份验证信息:\\\\r\\\\n\\\\t登录进程:\\\\t\\\\tAdvapi  \\\\r\\\\n\\\\t身份验证数据包:\\\\tNegotiate\\\\r\\\\n\\\\t传递的服务:\\\\t-\\\\r\\\\n\\\\t数据包名(仅限 NTLM):\\\\t-\\\\r\\\\n\\\\t密钥长度:\\\\t\\\\t0\\\\r\\\\n\\\\r\\\\n创建登录会话时，将在被访问的计算机上生成此事件。\\\\r\\\\n\\\\r\\\\n“使用者”字段指示本地系统上请求登录的帐户。这通常是一个服务(例如 Server 服务)或本地进程(例如 Winlogon.exe 或 Services.exe)。\\\\r\\\\n\\\\r\\\\n“登录类型”字段指示发生的登录类型。最常见的类型是 2 (交互式)和 3 (网络)。\\\\r\\\\n\\\\r\\\\n“新登录”字段指示新登录是为哪个帐户创建的，即已登录的帐户。\\\\r\\\\n\\\\r\\\\n“网络”字段指示远程登录请求源自哪里。“工作站名称”并非始终可用，并且在某些情况下可能会留空。\\\\r\\\\n\\\\r\\\\n“模拟级别”字段指示登录会话中的进程可以模拟到的程度。\\\\r\\\\n\\\\r\\\\n“身份验证信息”字段提供有关此特定登录请求的详细信息。\\\\r\\\\n\\\\t- “登录 GUID”是可用于将此事件与 KDC 事件关联起来的唯一标识符。\\\\r\\\\n\\\\t-“传递的服务”指示哪些中间服务参与了此登录请求。\\\\r\\\\n\\\\t-“数据包名”指示在 NTLM 协议中使用了哪些子协议。\\\\r\\\\n\\\\t-“密钥长度”指示生成的会话密钥的长度。如果没有请求会话密钥，则此字段将为 0。</Message><Level>信息</Level><Task>Logon</Task><Opcode>信息</Opcode><Channel>Security</Channel><Provider>Microsoft Windows security auditing.</Provider><Keywords><Keyword>审核成功</Keyword></Keywords></RenderingInfo></Event>");
//        testList.add("<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TerminalServices-LocalSessionManager' Guid='{5D896912-022D-40AA-A3A8-4FA5515C76D7}'/><EventID>24</EventID><Version>0</Version><Level>4</Level><Task>0</Task><Opcode>0</Opcode><Keywords>0x1000000000000000</Keywords><TimeCreated SystemTime='2019-10-31T08:17:56.083725400Z'/><EventRecordID>3040</EventRecordID><Correlation ActivityID='{61A55000-55E5-1017-0000-000000000000}'/><Execution ProcessID='1068' ThreadID='2240'/><Channel>Microsoft-Windows-TerminalServices-LocalSessionManager/Operational</Channel><Computer>HBASSHC02754.HBAS.RDC</Computer><Security UserID='S-1-5-18'/></System><UserData><EventXML xmlns='Event_NS'><User>HBAS\\RD02931</User><SessionID>3</SessionID><Address>本地</Address></EventXML></UserData><RenderingInfo Culture='zh-CN'><Message>远程桌面服务: 会话已断开连接:\n" +
//                "\n" +
//                "用户: HBAS\\RD02931\n" +
//                "会话 ID: 3\n" +
//                "源网络地址: 本地</Message><Level>信息</Level><Task></Task><Opcode>信息</Opcode><Channel></Channel><Provider>Microsoft-Windows-TerminalServices-LocalSessionManager</Provider><Keywords></Keywords></RenderingInfo></Event>");
        //2.此处可修改或者增加日志记录；
//        testList.add("162.105.29.85 - - [01/Dec/2018:15:47:35 +0800] \"GET /gbrsc/images/glxy_02.gif HTTP/1.1\" 200 254 \"http://www.sbs.edu.cn/gbrsc/\" \"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36\"\n");
//        testList.add("219.220.250.110 - - [30/Jun/2015:23:59:58 +0800] \"GET /images/sbs_functions222.js HTTP/1.1\" 200 24615 \"http://www.sbs.edu.cn/\" \"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Shuame)\"");
        // testList.add("<132>Jan  1 08:44:43 2812244172002540(root) 460c9413 Threat@FLOW: From 172.31.164.172:55707(xethernet0/9) to 192.168.0.2:53916(-), threat name: udp-flood, threat type: Dos, threat subtype: -, App/Protocol: IPv4/UDP, action: DROP, defender: AD, severity: Middle, zone INT-9712: UDP flood attack, occurred 96 times in the last 21 seconds");
        // testList.add("2020-01-14 13:37:54,Jing Jinsong,信息,登录,172.20.52.16,54-85-43-D0-CA-0F,登录 Windows客户端 成功,,AnyShare-WinClient,{\"obj_id\":\"\",\"user_account\":\"YT00247@boschhuayu-steering.com\"}\\n");
        //testList.add("{\"@timestamp\":\"2020-01-14T05:38:28.000Z\",\"severity\":6,\"message\":\"2020-01-14 13:37:54,Jing Jinsong,信息,登录,172.20.52.16,54-85-43-D0-CA-0F,登录 Windows客户端 成功,,AnyShare-WinClient,{\\\"obj_id\\\":\\\"\\\",\\\"user_account\\\":\\\"YT00247@boschhuayu-steering.com\\\"}\\n\",\"priority\":142,\"pid\":\"23621\",\"facility\":17,\"host\":\"172.16.200.196\",\"timestamp\":\"Jan 14 13:38:28\",\"format_level\":\"0\",\"facility_label\":\"local1\",\"received_at\":\"2020-01-14T13:37:54+08:00\",\"severity_label\":\"Informational\",\"log_class\":\"eisoo-network-disk\",\"logsource\":\"localhost\",\"program\":\"eacplogdaemon\",\"@version\":\"1\",\"type\":\"eisoo-network-disk\"}");
        //testList.add("{\"@timestamp\":\"2020-01-14T05:50:29.000Z\",\"severity\":6,\"message\":\"2020-01-14 13:50:15,admin,信息,登录,172.16.220.76,,登录 Web控制台 成功,,,{\\\"obj_id\\\":\\\"\\\",\\\"user_account\\\":\\\"admin\\\"}\\n\",\"priority\":142,\"pid\":\"23621\",\"facility\":17,\"host\":\"172.16.200.196\",\"timestamp\":\"Jan 14 13:50:29\",\"format_level\":\"0\",\"facility_label\":\"local1\",\"received_at\":\"2020-01-14T13:49:55+08:00\",\"severity_label\":\"Informational\",\"log_class\":\"eisoo-network-disk\",\"logsource\":\"localhost\",\"program\":\"eacplogdaemon\",\"@version\":\"1\",\"type\":\"eisoo-network-disk\"}\n");
        //testList.add("{\"@timestamp\":\"2020-01-14T07:26:36.000Z\",\"severity\":6,\"message\":\"2020-01-14 15:25:35,222,信息,上传,172.16.200.167,,上传文件“logout.log”成功,父路径: AnyShare://222,Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.87 Safari/537.36,{\\\"obj_id\\\":\\\"46A8B50DCE1C4FBABB4F0C6F9E035FF4\\\",\\\"user_account\\\":\\\"222\\\"}\\n\",\"priority\":158,\"pid\":\"23621\",\"facility\":19,\"host\":\"172.16.200.196\",\"timestamp\":\"Jan 14 15:26:36\",\"format_level\":\"0\",\"facility_label\":\"local3\",\"received_at\":\"2020-01-14T15:26:02+08:00\",\"severity_label\":\"Informational\",\"log_class\":\"eisoo-network-disk\",\"logsource\":\"localhost\",\"program\":\"eacplogdaemon\",\"@version\":\"1\",\"type\":\"eisoo-network-disk\"}");
        //  testList.add("{\"@timestamp\":\"2020-01-14T07:48:11.000Z\",\"severity\":6,\"message\":\"2020-01-14 15:47:37,111,信息,下载,172.16.200.167,,下载文件“FAQ_AS_CN.pdf”成功,父路径: AnyShare://test1,Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.87 Safari/537.36,{\\\"obj_id\\\":\\\"C5C142C3AA574C81B316C72181DA7ABA\\\",\\\"user_account\\\":\\\"111\\\"}\\n\",\"priority\":158,\"pid\":\"45078\",\"facility\":19,\"host\":\"172.16.200.196\",\"timestamp\":\"Jan 14 15:48:11\",\"format_level\":\"0\",\"facility_label\":\"local3\",\"received_at\":\"2020-01-14T15:47:37+08:00\",\"severity_label\":\"Informational\",\"log_class\":\"eisoo-network-disk\",\"logsource\":\"localhost\",\"program\":\"eacplogdaemon\",\"@version\":\"1\",\"type\":\"eisoo-network-disk\"}");
//        testList.add("{\"@timestamp\":\"2020-01-14T06:26:27.000Z\",\"severity\":6,\"message\":\"[21078][INFO] Add firewall rule ncTFirewallInfo(protocol='tcp', service_desc='', source_net='', role_sys='basic', dest_net='', port=3320) end\\n\",\"priority\":14,\"facility\":1,\"host\":\"172.16.200.196\",\"timestamp\":\"Jan 14 14:26:27\",\"format_level\":\"0\",\"facility_label\":\"user-level\",\"received_at\":\"2020-01-14T14:25:54+08:00\",\"severity_label\":\"Informational\",\"log_class\":\"eisoo-network-disk\",\"logsource\":\"localhost\",\"program\":\"FirewallManager\",\"@version\":\"1\",\"type\":\"eisoo-network-disk\"}\n");
        //    testList.add("{\"Metafield_object\":\"172.16.201.211\",\"Metafield_loglevel\":\"0\",\"@timestamp\":\"2020-01-15T09:44:50.075+08:00\",\"Metafield_type\":\"boyi_default_all_v1\",\"Metafield_subject\":\"172.16.201.211\",\"received_at\":\"2020-01-15T09:44:50.075+08:00\",\"Metafield_description\":\"弋搜采集日志\",\"ported_at\":\"2020-01-15T09:44:50.200+08:00\",\"message\":\"ipni dos warning(4) [1579052799.290115] VRF 0: DoS type unicast dest-ip/multicast-mac from 10.97.152.15/00:10:f3:3c:5b:e0 on port 1/1/22 \\n\",\"Metafield_source\":\"172.16.201.211\",\"Metafield_category\":\"redisShipper\"}\n");
        // testList.add("{\"Metafield_object\":\"172.16.201.211\",\"Metafield_loglevel\":\"0\",\"@timestamp\":\"2020-01-15T09:44:50.075+08:00\",\"Metafield_type\":\"boyi_default_all_v1\",\"Metafield_subject\":\"172.16.201.211\",\"received_at\":\"2020-01-15T09:44:50.075+08:00\",\"Metafield_description\":\"弋搜采集日志\",\"ported_at\":\"2020-01-15T09:44:50.200+08:00\",\"message\":\"ipni dos warning(4) [1579052799.290115] VRF 0: DoS type unicast dest-ip/multicast-mac from 10.97.152.15/00:10:f3:3c:5b:e0 on port 1/1/22 \\n\",\"Metafield_source\":\"172.16.201.211\",\"Metafield_category\":\"redisShipper\"}");
        //testList.add("{\"Metafield_object\":\"172.16.201.211\",\"Metafield_loglevel\":\"0\",\"@timestamp\":\"2020-01-15T10:03:52.403+08:00\",\"Metafield_type\":\"boyi_default_all_v1\",\"Metafield_subject\":\"172.16.201.211\",\"received_at\":\"2020-01-15T10:03:52.403+08:00\",\"Metafield_description\":\"弋搜采集日志\",\"ported_at\":\"2020-01-15T10:03:52.404+08:00\",\"message\":\"ipni arp info(5) [1579053938.462800] arp info overwritten for 10.97.31.101 by 006016:9975c4 port 4/2/6\\n\",\"Metafield_source\":\"172.16.201.211\",\"Metafield_category\":\"redisShipper\"}\n");
        //testList.add("{\"Metafield_object\":\"172.16.201.211\",\"Metafield_loglevel\":\"0\",\"@timestamp\":\"2020-01-15T10:11:08.643+08:00\",\"Metafield_type\":\"boyi_default_all_v1\",\"Metafield_subject\":\"172.16.201.211\",\"received_at\":\"2020-01-15T10:11:08.643+08:00\",\"Metafield_description\":\"弋搜采集日志\",\"ported_at\":\"2020-01-15T10:11:08.723+08:00\",\"message\":\"ipni dos warning(4) [1579054374.436362] to 10.97.186.255/ff:ff:ff:ff:ff:ff.\\n\",\"Metafield_source\":\"172.16.201.211\",\"Metafield_category\":\"redisShipper\"}\n");
//        testList.add("ipni dos warning(4) [1578992093.406953] to 10.97.186.255/ff:ff:ff:ff:ff:ff.");
        //  testList.add("30,12/02/19,00:00:07,DNS 更新请求,101.132.139.181,BHSHC02318.boschhuayu-steering.com,,,0,6,,,,,,,,,0");
//        testList.add("2019/12/5 13:03:54 0714 PACKET  0000001805BEC250 UDP Snd 210.22.84.3     06ea   Q [0001   D   NOERROR] AAAA   (6)adashx(1)m(6)taobao(3)com(3)gds(10)alibabadns(3)com(0)");
//        testList.add("[/var/lib/jenkins/workspace/ShareServer_Release-Polaris-M5/Release-Polaris-M5/AnyShare/ShareServer/src/acsprocessor/ncACSLogManager.cpp:560]:Push (logType: 12) 1 logs, lastLogid: 131827\\n");
//        testList.add("2020-02-10 08:56:56,Hu Chong,信息,下载,172.24.160.22,8C-16-45-D2-47-3B,下载文件“20191110--20191231.pst”成功,父路径: AnyShare://Hu Chong,AnyShare-WinClient,{\\\"obj_id\\\":\\\"0CE5A8DB15C848EC924076E16C0DFEAA\\\",\\\"user_account\\\":\\\"WH00189@boschhuayu-steering.com\\\"}\\n");
//            testList.add("2020-02-10 08:56:56,Hu Chong,信息,下载,172.24.160.22,8C-16-45-D2-47-3B,下载文件“20191110--20191231.pst”成功,父路径: AnyShare://Hu Chong,AnyShare-WinClient,{\"obj_id\":\"0CE5A8DB15C848EC924076E16C0DFEAA\",\"user_account\":\"WH00189@boschhuayu-steering.com\"}\\n");
//        testList.add("2020-02-26 16:57:58,Huang Zhiyong,信息,登出,172.20.52.40,8C-16-45-3E-8A-21,退出 Windows客户端 成功,,AnyShare-WinClient,{\\\"obj_id\\\":\\\"\\\",\\\"user_account\\\":\\\"GC00569@boschhuayu-steering.com\\\"}\\n");
//        testList.add("2020-02-26 15:38:47,Wu Simin,警告,删除,172.16.26.30,,删除文件“保密协议（0226修改）.pdf”到回收站成功,父路径: AnyShare://Wu Simin/交大协议/注释版,Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36,{\"obj_id\":\"CCFE6A07FECB4C0096AF571A5DC62EA2\",\"user_account\":\"GC01713@boschhuayu-steering.com\"}");
//        testList.add("2020-02-26 16:57:58,Huang Zhiyong,信息,登出,172.20.52.40,8C-16-45-3E-8A-21,退出 Windows客户端 成功,,AnyShare-WinClient,{\"obj_id\":\"\",\"user_account\":\"GC00569@boschhuayu-steering.com\"}");
//        testList.add("[61857][INFO] Set iptables rule begin, access rule: [ncTIptablesInfo(service_port='8000', dest_net='', protocol='tcp', source_net=''), ncTIptablesInfo(service_port='80', dest_net='', protocol='tcp', source_net=''), ncTIptablesInfo(service_port='443', dest_net='', protocol='tcp', source_net=''), ncTIptablesInfo(service_port='9123', dest_net='', protocol='tcp', source_net=''), ncTIptablesInfo(service_port='9124', dest_net='', protocol='tcp', source_net=''), ncTIptablesInfo(service_port='9998', dest_net='', protocol='tcp', source_net=''), ncTIptablesInfo(service_port='9999', dest_net='', protocol='tcp', source_net=''), ncTIptablesInfo(service_port='5557', dest_net='', protocol='tcp', source_net=''), ncTIptablesInfo(service_port='9028', dest_net='', protocol='tcp', source_net=''), ncTIptablesInfo(service_port='9029', dest_net='', protocol='tcp', source_net=''), ncTIptablesInfo(service_port='22', dest_net='', protocol='tcp', source_net=''), ncTIptablesInfo(service_port='3320', dest_net='', protocol='tcp', source_n\\n");
//        testList.add("2020-02-26 17:19:41,Wang Zheng,信息,上传,172.16.154.101,F8-B1-56-DE-0C-61,上传文件“WinWert.fdc”成功,父路径: AnyShare://Wang Zheng/I-shaft/2020_1_22,AnyShare-WinClient,{\"obj_id\":\"A787516D606345918032D6A1320DF701\",\"user_account\":\"gc02912\"}");
//        testList.add("2020-02-26 16:34:01,Wu Simin,信息,登出,172.16.26.30,54-E1-AD-93-13-6D,退出 Windows客户端 成功,,AnyShare-WinClient,{\\\"obj_id\\\":\\\"\\\",\\\"user_account\\\":\\\"GC01713@boschhuayu-steering.com\\\"}\\n");
//        testList.add("2020-02-26 16:34:01,Wu Simin,信息,登出,172.16.26.30,54-E1-AD-93-13-6D,退出 Windows客户端 成功,,AnyShare-WinClient,{\"obj_id\":\"\",\"user_account\":\"GC01713@boschhuayu-steering.com\"}");
//         testList.add("2020-02-26 13:51:17,Wu Simin,信息,登录,172.16.26.30,54-E1-AD-93-13-6D,登录 Windows客户端 成功,,AnyShare-WinClient,{\"obj_id\":\"\",\"user_account\":\"GC01713@boschhuayu-steering.com\"}\n");
//       testList.add("2020-02-11 12:27:53,admin,信息,设置,172.16.21.119,,编辑用户 \\\"Wang Lu(YT00234@boschhuayu-steering.com)\\\" 成功,归属站点 “yantai”,,{\\\"obj_id\\\":\\\"\\\",\\\"user_account\\\":\\\"admin\\\"}\\n");
         testList.add("2020-02-11 12:27:53,admin,信息,设置,172.16.21.119,,编辑用户 \"Wang Lu(YT00234@boschhuayu-steering.com)\" 成功,归属站点 “yantai”,,{\"obj_id\":\"\",\"user_account\":\"admin\"}\\n");
//        testList.add("2020-02-26 15:51:50,Wu Simin,信息,重命名,172.16.26.30,54-E1-AD-93-13-6D,将文件夹“新建文件夹”重命名为“注释版回复”成功,父路径: AnyShare://Wu Simin/蜗轮协议,AnyShare-WinClient,{\"obj_id\":\"DDBE0ADD76CB4272BAEEF7B3907404FA\",\"user_account\":\"GC01713@boschhuayu-steering.com\"}");
        testList.add("2020-02-26 15:50:58,Wu Simin,信息,重命名,172.16.26.30,54-E1-AD-93-13-6D,将文件“保密协议1.pdf”重命名为“保密协议20200226.pdf”成功,父路径: AnyShare://Wu Simin/交大协议/注释版回复,AnyShare-WinClient,{\"obj_id\":\"4BFDC6721EC54925863DD12904B373DB\",\"user_account\":\"GC01713@boschhuayu-steering.com\"}");
        for (String s : testList) {
            Event e = new Event();
            e.setMessage(s);
            Indexer.format(e);
            System.out.println(e.getJsonMessage());
        }

    }

    @Test
    public void MappingtoJSON() {
        System.out.println(SangforFirewallAllV1Indexer.getMappingString());
    }

    @After
    public void AfterOne() {
        System.out.println("---测试结束---");
    }
}
