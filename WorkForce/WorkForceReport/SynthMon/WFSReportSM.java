
// *********************************************************************************************
//
// Automatically Generated Load Test Program
// -----------------------------------------
//
// Source: WFSReportSM.java
// Date  : 18 Dec 2019 14:20:14 PST
// Author: Apica ZebraTester V5.5-F / automatically generated
//
// Procedure Copyright by Ingenieurbuero David Fischer AG  |  A Company of the Apica Group
// All Rights Reserved
//
// http://www.apicasystem.com                                         http://www.zebratester.com
// *********************************************************************************************


import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.atomic.*;
import dfischer.utils.AbstractInputFileReader;
import dfischer.utils.Base64Decoder;
import dfischer.utils.Base64Encoder;
import dfischer.utils.ConvertToDoubleNumber;
import dfischer.utils.ContentTokenExtractor;
import dfischer.utils.ContentTokenExtractorItem;
import dfischer.utils.Cookie;
import dfischer.utils.CookieHandler;
import dfischer.utils.DigestAuthContext;
import dfischer.utils.DNSCache;
import dfischer.utils.DNSTranslationTable;
import dfischer.utils.DynamicProtobufContentParser;
import dfischer.utils.ExternalParamFile;
import dfischer.utils.FileCache;
import dfischer.utils.GenericPluginInterface;
import dfischer.utils.GetRealTimeUserInputFieldsInterface;
import dfischer.utils.HtmlContentParser;
import dfischer.utils.HtmlHeaderCookieExtractor;
import dfischer.utils.HttpLoadTest;
import dfischer.utils.HttpLoadTestIncrementUserThread;
import dfischer.utils.HttpLoadTestUserContext;
import dfischer.utils.HttpSocketPool;
import dfischer.utils.HttpTestURL;
import dfischer.utils.HttpTestURLDNSContext;
import dfischer.utils.HttpTestURLThreadHandler;
import dfischer.utils.InlineScriptExecutionException;
import dfischer.utils.InlineScriptExecutor;
import dfischer.utils.InnerLoopContext;
import dfischer.utils.JSONHtmlBasedExtractor;
import dfischer.utils.JSONPathBasedExtractor;
import dfischer.utils.JSONPathBasedExtractorItem;
import dfischer.utils.Lib;
import dfischer.utils.LoadtestInlineScriptContext;
import dfischer.utils.LoadtestInlineScriptVar;
import dfischer.utils.LoadtestPluginClassLoader;
import dfischer.utils.LoadtestPluginContext;
import dfischer.utils.NextProxyConfig;
import dfischer.utils.ParseArgs;
import dfischer.utils.ParseUrl;
import dfischer.utils.PerformanceData;
import dfischer.utils.PerformanceDataTickExtension;
import dfischer.utils.ProtobufFieldAndValueElement;
import dfischer.utils.ProtobufLib;
import dfischer.utils.RealTimeUserInputField;
import dfischer.utils.ScreenshotImage;
import dfischer.utils.SetThreadStepInterface;
import dfischer.utils.SSLInit;
import dfischer.utils.SSLSessionCacheStatistic;
import dfischer.utils.SSLSessionCacheStatisticInterface;
import dfischer.utils.SuspendResumeInterface;
import dfischer.utils.SymmetricEncrypt;
import dfischer.utils.SymmetricEncryptContext;
import dfischer.utils.TextLineTokenExtractor;
import dfischer.utils.TextLineTokenExtractorItem;
import dfischer.utils.ThreadStepInterface;
import dfischer.utils.UserInputField;
import dfischer.utils.UserTransactionContext;
import dfischer.utils.UserTransactionRuntimeHandler;
import dfischer.utils.VarInputFileReader;
import dfischer.utils.VarRandomInputFileReader;
import dfischer.utils.VaryingLoadInterface;
import dfischer.utils.VaryingTestDurationInterface;
import dfischer.utils.XmlContentParser;
import dfischer.utils.XmlDoctypeCommentParser;
import dfischer.utils.ZoneTime;
import dfischer.proxysniffer.ProxySnifferVarSourceInlineScript;
import dfischer.utils.WebSocketPluginInterface;
import dfischer.utils.BoundaryBasedExtractor;
import dfischer.utils.BoundaryBasedExtractorItem;
import dfischer.utils.RegExpBasedExtractor;
import dfischer.utils.RegExpBasedExtractorItem;
import dfischer.utils.XpathBasedExtractor;
import dfischer.utils.XpathBasedExtractorItem;
import dfischer.proxysniffer.WebSocketData;
import dfischer.utils.HttpTestWebsocketContext;
import dfischer.websocket.*;


/**
 * Automatically generated load test program.
 */
public class WFSReportSM extends HttpLoadTest implements Runnable, ThreadStepInterface, SetThreadStepInterface, SSLSessionCacheStatisticInterface, VaryingLoadInterface, VaryingTestDurationInterface, SuspendResumeInterface, GetRealTimeUserInputFieldsInterface
{
	public static final String prxVersion = "V5.5-F";
	public static final int    prxCharEncoding = 3;                         // 1 = OS Default, 2 = ISO-8859-1, 3 = UTF-8
	public static final String testDescription = "WFSReport1_Correlated";

	public static String USER_AGENT_1 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:70.0) Gecko/20100101 Firefox/70.0";

	private static final boolean CONTAINS_PARALLEL_EXECUTED_URLS = false;
	private static final int MAX_PARALLEL_THREADS_PER_USER = 6;                       // default value for max. parallel executed URLs per user
	private static int maxParallelThreadsPerUser = MAX_PARALLEL_THREADS_PER_USER;     // configured value for max. parallel executed URLs per user

	private static final boolean CONTAINS_EXTERNAL_RESOURCES = false;       // note: external resources are typically additional Java library files (*.jar files) invoked by self-developed plug-ins. Consider that Input Files and the Main Class of Plug-Ins are NOT external resources in this context because ZebraTester knows already their declarations.

	// --- WebSocket Object ---
	WebSocketData webSocketData = null;                                     // WebSocket Object that contains data of recorded WebSocket frames.
	WebSocketPluginInterface[] webSocketPluginsForURL = null;               // all assiciated web socket plugins for specific URL.

	// --- proxy configuration ---
	private static boolean proxyEnabled = false;                             // if false: do not use a proxy server
	private static boolean proxyCacheDisabled = true;
	private static String  proxyHttpHost = "";
	private static int     proxyHttpPort = -1;
	private static String  proxyHttpsHost = "";
	private static int     proxyHttpsPort = -1;
	private static String  noProxyFor = "";
	private static String  proxyAuthorization = null;
	private static NextProxyConfig commonNextProxyConfig = null;
	private NextProxyConfig userNextProxyConfig = null;
	
	private static int plannedStartupDelay = 200;                           // startup delay between concurrent users in milliseconds, see main argument "-sdelay"
	private static int plannedTestDuration = -1;                            // planned load test duration in seconds, 0 = unlimited, see main argument "-d"
	private static int maxPlannedLoops = 0;  								   // maximum planned loops per user, 0 = unlimited, see main argument "-maxloops"
	private static int plannedRequestTimeout = 0;                           // planned request timeout in seconds, see main argument "-t"
	private static int plannedConnectTimeout = 0;                           // planned TCP/IP socket connect timeout in seconds (default = use plannedRequestTimeout), see main argument "-tconnect"
	
	private static String defaultTimeZone = "PST";                          // use main argument -tz <timezone> to alter
	private static char defaultNumberGroupingSeparator = '\'';              // use main argument -dgs a|c to alter
	private static String sslProtocolVersion = "all";                       // applied ssl protocol version: "all" = v3/tls/tls11/tls12, use main argument -ssl to set a fixed protocol version
	private static boolean sslcmode = false;                                // support of deficient ssl servers, use main argument -sslcmode to enable
	private static boolean sslECC = false;                                  // elliptic curve cryptography (ECC) is disabled by default, use main argument -ecc to enable
	private static boolean sslSNI = true;                                   // server name indication (SNI) is enabled by default, use main argument -nosni to disable
	private static boolean sslSNICirical = false;                           // the SNI TLS extension is by default set as non-critical, use main argument -snicritical to set as critical
	private static boolean useTlsSessionTickets = false;                    // Session Tickets can only be used with TLS, use main argument -tlssessiontickets to set to use
	private static final long loopErrorDelay = 20;                          // error delay (in milliseconds) applied if a loop of a virtual user has failed
	private static final String THREAD_NAME = "T000000";                    // internal
	private static Integer dumpLock = new Integer(0);                       // internal
	private static Integer inputFileLock = new Integer(0);                  // internal
	private volatile int threadStep = ThreadStepInterface.THREAD_NO_STEP;   // internal
	private boolean urlCallPassed = false;                                  // internal
	private String localIpAddress = null;                                   // internal
	private static long downlinkBandwidth = 0;                              // max. downlink bandwidth per user. 0 = unlimited. use main argument -downlink <kbps> to alter
	private static long uplinkBandwidth = 0;                                // max. uplink bandwidth per user. 0 = unlimited. use main argument -uplink <kbps> to alter
	private static boolean dnsPerLoop = false;								// true if main argument "-dnsperloop" is set = perform new DNS resolves for each executed loop. normally false
	private HttpTestURLDNSContext userDNSContext = null;                    // user specific DNS context - normally null when no special DNS servers are used
	
	private static volatile boolean debugFailedLoops = false;               // true if main argument "-dfl" is set
	private static volatile boolean debugLoops = false;                     // true if main argument "-dl" is set
	private static volatile boolean debugHttp = false;                      // true if main argument "-dh" is set
	private static volatile boolean debugContent = false;                   // true if main argument "-dc" is set
	private static volatile boolean debugCookies = false;                   // true if main argument "-dC" is set
	private static volatile boolean debugKeepAlive = false;                 // true if main argument "-dK" is set
	private static volatile boolean debugSsl = false;                       // true if main argument "-dssl" is set
	
	private static String resultFile = null;                                // name of binary test result file or null
	
	private final static String httpProtocolVersion = "1.1";      // applied HTTP protocol version V1.1
	
	private static ExternalParamFile externalParamFile = null;                              // used only for very large parameter values (commonly unused)
	private static final String EXTERNAL_PARAM_FILE = "WFSReportSMExtParams.dat";           // input file name for very large parameter values
	private static FileCache requestFileCache = new FileCache();  // file cache for large XML, SOAP and ASCII requests
	
	private int requestTimeout = -1;                              // thread input data from constructor, timeout per url request in seconds
	private int remainingLoops = -1;                              // thread input data from constructor, number of loops per thread (optional)
	private boolean checkLoopCount = false;                       // thread input data from constructor, number of loops per thread (optional)
	private int threadNumber = -1;                                // thread input data from constructor, internal thread number
	private int threadLoopCounter = 0;                            // internal loop counter per thread
	private volatile int userResumeStartWaitDelay = 0;            // internal, user specific delay when the load test execution is resumed
	private volatile boolean decrementEndOfLoopFlag = false;	  // internal flag to decrement the simulated user at runtime
	private volatile boolean incrementUserFlag = false;           // internal flag to increment the simulated user at runtime
	private volatile long incrementUserStartTime = -1;            // internal start time when increment the simulated user at runtime
	private static AtomicInteger totalLoopCounter = new AtomicInteger(0);    // internal overall loop counter

	private LoadtestPluginContext userPluginContext = null;       // plug-in context per user
	private LoadtestInlineScriptContext inlineScriptContext = null;          // re-used, scratch, the returned context of an inline script that runs at item or URL exec scope

	private Object sslSessionCache = null;                        // internal ssl session cache per thread
	private SSLSessionCacheStatistic sslStatistic = null;         // internal ssl session cache statistic per thread
	private static int sslSessionCacheTimeout = 300;              // timeout of ssl session cache in seconds, 0 = session cache disabled
	private static int sslHandshakeRandomGeneratorType = -1;      // invalid initial value, use the default secure random generator for SSL handshakes
	private HttpSocketPool socketPool = null;                     // re-used, scratch, internal socket pool per thread and loop
	private CookieHandler cookieHandler = null;                   // re-used, scratch, internal cookie handler per thread and loop

	private HttpTestURL testURL = null;                           // re-used, scratch, http request and response
	private HttpTestURLThreadHandler pageThreadHandler = null;    // re-used, scratch, support for parallel processing of http request within a page
	private int httpStatus = -1;                                  // re-used, scratch, http response status code from webserver
	private HtmlContentParser htmlContentParser = null;           // re-used, scratch, used to extract vars from http response
	private XmlContentParser xmlContentParser = null;             // re-used, scratch, used to extract vars from http response
	private JSONHtmlBasedExtractor jsonHtmlBasedExtractor = null; // re-used, scratch, used to extract vars from http response
	private DynamicProtobufContentParser protobufContentParser = null;  // re-used, scratch, used to extract vars from http response
	private TextLineTokenExtractor textLineTokenExtractor = null; // re-used, scratch, used to extract vars from http response
	private ContentTokenExtractor contentTokenExtractor = null;   // re-used, scratch, used to extract vars from http response
	private BoundaryBasedExtractor boundaryBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private RegExpBasedExtractor regExpBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private XpathBasedExtractor xpathBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private JSONPathBasedExtractor jsonPathBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	
	private static VarInputFileReader Login_txt = null;              // input file Login.txt, file scope: new line per user

	private volatile UserTransactionRuntimeHandler transactionHandler = new UserTransactionRuntimeHandler();		// re-used, support to manage user-defined transactions
	private Map<String,String> transactionContextMap = new HashMap<>();		// used to correctly measure the user-defined transactions

	private String P_Password = null;                                     // var declaration from web admin var handler: scope = per user
	private String P_UserID = null;                                       // var declaration from web admin var handler: scope = per user

	private String C_js9 = null;                         // var declaration from web admin var handler: scope = per loop
	private String C_dynamicImage = null;                // var declaration from web admin var handler: scope = per loop
	private String C_js8 = null;                         // var declaration from web admin var handler: scope = per loop
	private String C_JsessionID2 = null;                 // var declaration from web admin var handler: scope = per loop
	private String C_js7 = null;                         // var declaration from web admin var handler: scope = per loop
	private String C_js6 = null;                         // var declaration from web admin var handler: scope = per loop
	private String C_JsessionID1 = null;                 // var declaration from web admin var handler: scope = per loop
	private String C_js5 = null;                         // var declaration from web admin var handler: scope = per loop
	private String C_js4 = null;                         // var declaration from web admin var handler: scope = per loop
	private String C_loggingID = null;                   // var declaration from web admin var handler: scope = per loop
	private String C_Js3 = null;                         // var declaration from web admin var handler: scope = per loop
	private String C_CsrfToken1 = null;                  // var declaration from web admin var handler: scope = per loop
	private String C_Js2 = null;                         // var declaration from web admin var handler: scope = per loop
	private String C_Js1 = null;                         // var declaration from web admin var handler: scope = per loop
	private String C_SrvID = null;                       // var declaration from web admin var handler: scope = per loop
	private String C_Css6 = null;                        // var declaration from web admin var handler: scope = per loop
	private String C_Css5 = null;                        // var declaration from web admin var handler: scope = per loop
	private String C_Css4 = null;                        // var declaration from web admin var handler: scope = per loop
	private String C_Css3 = null;                        // var declaration from web admin var handler: scope = per loop
	private String C_Css2 = null;                        // var declaration from web admin var handler: scope = per loop
	private String C_Css1 = null;                        // var declaration from web admin var handler: scope = per loop
	private String C_JSVersion = null;                   // var declaration from web admin var handler: scope = per loop
	
	/**
	 * constructor: called from load test plug-ins (scope = global).
	 */
	public WFSReportSM()
	{
		super();
	}


	/**
	 * constructor: called when a user is created (per user).
	 */
	public WFSReportSM(int maxLoops, int requestTimeout, int threadNumber)
	{
		super();
		this.requestTimeout = requestTimeout;
		this.remainingLoops = maxLoops;
		this.checkLoopCount = (maxLoops > 0);
		this.threadNumber = threadNumber;
		this.sslSessionCache = SSLInit.getNewSslSessionCache(sslSessionCacheTimeout);
		this.sslStatistic = new SSLSessionCacheStatistic();
		if (isMultihomed() && (!ipPerLoop()))
			this.localIpAddress = getNextMultihomedIpAddress();
		if (dnsCache != null)
			userDNSContext = new HttpTestURLDNSContext(dnsCache, threadNumber);
		
		// read next line from input file: scope = per user
		try
		{
			synchronized (inputFileLock)
			{
				if (!Login_txt.getNextLine())
					abortByEofInputFile();
				// extract vars from input file: scope = per user
				P_Password = new String(Login_txt.getLineVar(2));
				P_UserID = new String(Login_txt.getLineVar(1));
			}
		}
		catch (Exception ie)
		{
			abortByEofInputFile();
		}
		
		applyNextProxySettingsFromFileIfExists();
		
		if (commonNextProxyConfig != null)
			// set proxy configuration data per user 
			userNextProxyConfig = new NextProxyConfig(commonNextProxyConfig);
		
		// initialize context for plug-ins which are executed per user
		userPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber);
	}


	/**
	 * internal method: called when a user starts a loop.
	 * contains the recorded session which is called by users x loops.
	 * 
	 * @param totalLoopCounter total number of loops (0..n-1) counted overall threads. This value is unique per loop.
	 * 
	 * @return  true:  loop successful completed.
	 *          false: loop failed.
	 */
	private boolean execute(int totalLoopCounter) throws Exception
	{
		markStartOfLoop();
		threadStep = 0;                 // internal - start loop at thread step 0
		
		// enable DNS resolves per loop?
		if (dnsPerLoop)
			userDNSContext = new HttpTestURLDNSContext(dnsCache.clone(false), threadNumber);
		
		// debug http headers?
		Object httpLogVectorObject = null;
		if (debugHttp)
			httpLogVectorObject = this;
		
		// create socket pool per loop
		sslSessionCache = SSLInit.getNewSslSessionCache(sslSessionCacheTimeout);		// reset the SSL session cache to get new SSL session IDs for this loop
		socketPool = new HttpSocketPool(this, sslProtocolVersion, sslSessionCache, sslStatistic, sslcmode);
		if (plannedConnectTimeout > 0)
			socketPool.setConnectTimeout(plannedConnectTimeout);
		if (sslHandshakeRandomGeneratorType != -1)
			socketPool.setSslHandshakeRandomGeneratorType(sslHandshakeRandomGeneratorType);
		socketPool.setSupportEllipticCurves(sslECC);
		socketPool.setHintUseSNI(sslSNI);
		socketPool.setSniCritical(sslSNICirical);
		socketPool.setUseTlsSessionTickets(useTlsSessionTickets);
		if (debugKeepAlive)
		{
			socketPool.setlogVectorObject(this);
			if (debugSsl)
				socketPool.enableSslLog();
		}
		
		if (downlinkBandwidth > 0)
			socketPool.setDownlinkBandwidth(downlinkBandwidth);
		if (uplinkBandwidth > 0)
			socketPool.setUplinkBandwidth(uplinkBandwidth);
		
		if (isMultihomed())
		{
			if (ipPerLoop())
				localIpAddress = getNextMultihomedIpAddress();
			socketPool.setClientIpAddress(localIpAddress);
			log();
			log("multihomed client ip address = " + localIpAddress);
		}
		
		// setup cookie handler per loop
		cookieHandler = new CookieHandler();
		if (debugCookies)
			cookieHandler.setLogVectorInterface(this);
		
		// customised vars from web admin var handler: scope = per user
		log();
		log("<<< P_Password = " + P_Password);
		log("<<< P_UserID = " + P_UserID);
		
		// customised vars from web admin var handler: scope = per loop
		htmlContentParser = null;
		xmlContentParser = null;
		jsonHtmlBasedExtractor = null;
		protobufContentParser = null;
		C_js9 = null;
		C_dynamicImage = null;
		C_js8 = null;
		C_JsessionID2 = null;
		C_js7 = null;
		C_js6 = null;
		C_JsessionID1 = null;
		C_js5 = null;
		C_js4 = null;
		C_loggingID = null;
		C_Js3 = null;
		C_CsrfToken1 = null;
		C_Js2 = null;
		C_Js1 = null;
		C_SrvID = null;
		C_Css6 = null;
		C_Css5 = null;
		C_Css4 = null;
		C_Css3 = null;
		C_Css2 = null;
		C_Css1 = null;
		C_JSVersion = null;
		log();
		log("<<< C_js9 = " + C_js9);
		log("<<< C_dynamicImage = " + C_dynamicImage);
		log("<<< C_js8 = " + C_js8);
		log("<<< C_JsessionID2 = " + C_JsessionID2);
		log("<<< C_js7 = " + C_js7);
		log("<<< C_js6 = " + C_js6);
		log("<<< C_JsessionID1 = " + C_JsessionID1);
		log("<<< C_js5 = " + C_js5);
		log("<<< C_js4 = " + C_js4);
		log("<<< C_loggingID = " + C_loggingID);
		log("<<< C_Js3 = " + C_Js3);
		log("<<< C_CsrfToken1 = " + C_CsrfToken1);
		log("<<< C_Js2 = " + C_Js2);
		log("<<< C_Js1 = " + C_Js1);
		log("<<< C_SrvID = " + C_SrvID);
		log("<<< C_Css6 = " + C_Css6);
		log("<<< C_Css5 = " + C_Css5);
		log("<<< C_Css4 = " + C_Css4);
		log("<<< C_Css3 = " + C_Css3);
		log("<<< C_Css2 = " + C_Css2);
		log("<<< C_Css1 = " + C_Css1);
		log("<<< C_JSVersion = " + C_JSVersion);
		
		// initialize context for plug-ins which are executed per loop
		LoadtestPluginContext loopPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber, socketPool, cookieHandler);
		



		// --- VIRTUAL PAGE #0 ---
		if (!executePage_0(totalLoopCounter, loopPluginContext, new InnerLoopContext(), 0,0, httpLogVectorObject))
			return false;



		// --- PAGE BREAK: Test [0] ---
		log();
		log();
		log("# Page #1: LaunchPageURL");
		log("# ----------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #1: LaunchPageURL", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_1_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 1 failed
		
		// page 1 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [25] ---
		log();
		log();
		log("# Page #2: Login");
		log("# --------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #2: Login", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 2 failed
		
		// page 2 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [46] ---
		log();
		log();
		log("# Page #3: ViewReports");
		log("# --------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #3: ViewReports", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 3 failed
			synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 3 failed
		
		// page 3 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [59] ---
		log();
		log();
		log("# Page #4: Reports_AssignmentWorkGroupDetail");
		log("# ------------------------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #4: Reports_AssignmentWorkGroupDetail", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 4 failed
			synchResponsesParallelRequestsPage_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 4 failed
		
		// page 4 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [68] ---
		log();
		log();
		log("# Page #5: Run Report");
		log("# -------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #5: Run Report", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_5(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 5 failed
			synchResponsesParallelRequestsPage_5(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_5_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 5 failed
			synchResponsesParallelRequestsPage_5(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_5(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 5 failed
		
		// page 5 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [97] ---
		log();
		log();
		log("# Page #6: LogOut");
		log("# ---------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #6: LogOut", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_6(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 6 failed
			synchResponsesParallelRequestsPage_6(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_6(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 6 failed
		
		// page 6 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);
		
		
		// loop successful done
		// --------------------
		
		markEndOfPage(performanceData);
		
		endOfExecuteLoop(true, null, -1, loopPluginContext);
		log();
		return true;
	}		// end of execute()
		
		
		
	/**
	 * internal method: called when a user has completed a loop.
	 */
	private void endOfExecuteLoop(boolean loopPassed, HttpTestURL testURL, int threadStep, LoadtestPluginContext loopPluginContext) throws Exception
	{
		// log URL if last call has failed
		if ((!loopPassed) && (testURL != null))
			log(testURL);
		
		// update plugin context
		loopPluginContext.setLoopPassed(loopPassed);
		if ((testURL != null) && (loopPluginContext.getHttpTestURL() == null))
			loopPluginContext.setHttpTestURL(testURL);
		if ((threadStep != -1) && (loopPluginContext.getThreadStep() == -1))
			loopPluginContext.setThreadStep(threadStep);
	}


	/**
	 * Recorded http requests of page #0.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_0(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{

		// all http requests of page #0 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #1: LaunchPageURL
		// # ----------------------



		// --- HTTP REQUEST: Test [1] <- WEB ADMIN Index 1 ---
		log();
		log("# title: WorkForce Time");
		String requestProt0001 = "https";
		String requestHost0001 = "teck-test.wfsaas.ca";
		int    requestPort0001 = 443;
		String requestFile0001 = "/workforce/Desktop.do";
		String requestHeader0001 = "GET " + requestFile0001 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0001, requestHost0001, requestPort0001, requestHeader0001, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0001 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 6644
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "User ID");		// Test [1] <- Index 1
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getContentString());

		// setup var extractor for 'C_js4'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0001_1 = new BoundaryBasedExtractorItem( "bannerComponentsJs_" , ".js",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0001_1);

		// setup var extractor for 'C_Js3'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0001_2 = new BoundaryBasedExtractorItem( "statusListJs_" , ".js",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0001_2);

		// setup var extractor for 'C_Js2'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0001_3 = new BoundaryBasedExtractorItem( "extJs_" , ".js",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0001_3);

		// setup var extractor for 'C_Js1'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0001_4 = new BoundaryBasedExtractorItem( "coreJs_" , ".js",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0001_4);

		// setup var extractor for 'C_Css4'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0001_5 = new BoundaryBasedExtractorItem( "systemTimeSwitcherCss_" , ".css",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0001_5);

		// setup var extractor for 'C_Css3'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0001_6 = new BoundaryBasedExtractorItem( "ComponentsCss_" , ".css",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0001_6);

		// setup var extractor for 'C_Css2'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0001_7 = new BoundaryBasedExtractorItem( "coreCss_" , ".css",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0001_7);

		// setup var extractor for 'C_Css1'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0001_8 = new BoundaryBasedExtractorItem( "extJsCss_" , ".css",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0001_8);

		// setup var extractor for 'C_JSVersion'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0001_9 = new BoundaryBasedExtractorItem( "ver=" , "\" />",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0001_9);

		boundaryBasedExtractor.extractText();
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getHeaderString());

		// setup var extractor for 'C_JsessionID1'
		BoundaryBasedExtractorItem boundaryBasedHeaderExtractorItem0001_1 = new BoundaryBasedExtractorItem( "JSESSIONID=" , ";",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedHeaderExtractorItem0001_1);

		// setup var extractor for 'C_SrvID'
		BoundaryBasedExtractorItem boundaryBasedHeaderExtractorItem0001_2 = new BoundaryBasedExtractorItem( "srv_id=" , ";",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedHeaderExtractorItem0001_2);

		boundaryBasedExtractor.extractText();
		try
		{
			// extract var 'C_JsessionID1'
			C_JsessionID1 = boundaryBasedHeaderExtractorItem0001_1.getResultText();
			log("<<< C_JsessionID1 = " + C_JsessionID1);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_JsessionID1!= null && C_JsessionID1.trim().length() == 0)
			{
				C_JsessionID1 = "";
				log("runtime note: the extraction of a new value for the variable 'C_JsessionID1' ends up with an empty string - a substitute value was set");
				log("<<< C_JsessionID1 = " + C_JsessionID1);
			}
		}
		catch (Exception e) { C_JsessionID1 = null; log(e); }
		if (C_JsessionID1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_JsessionID1' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_js4'
			C_js4 = boundaryBasedContentExtractorItem0001_1.getResultText();
			log("<<< C_js4 = " + C_js4);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_js4!= null && C_js4.trim().length() == 0)
			{
				C_js4 = "";
				log("runtime note: the extraction of a new value for the variable 'C_js4' ends up with an empty string - a substitute value was set");
				log("<<< C_js4 = " + C_js4);
			}
		}
		catch (Exception e) { C_js4 = null; log(e); }
		if (C_js4 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_js4' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_Js3'
			C_Js3 = boundaryBasedContentExtractorItem0001_2.getResultText();
			log("<<< C_Js3 = " + C_Js3);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_Js3!= null && C_Js3.trim().length() == 0)
			{
				C_Js3 = "";
				log("runtime note: the extraction of a new value for the variable 'C_Js3' ends up with an empty string - a substitute value was set");
				log("<<< C_Js3 = " + C_Js3);
			}
		}
		catch (Exception e) { C_Js3 = null; log(e); }
		if (C_Js3 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_Js3' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_Js2'
			C_Js2 = boundaryBasedContentExtractorItem0001_3.getResultText();
			log("<<< C_Js2 = " + C_Js2);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_Js2!= null && C_Js2.trim().length() == 0)
			{
				C_Js2 = "";
				log("runtime note: the extraction of a new value for the variable 'C_Js2' ends up with an empty string - a substitute value was set");
				log("<<< C_Js2 = " + C_Js2);
			}
		}
		catch (Exception e) { C_Js2 = null; log(e); }
		if (C_Js2 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_Js2' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_Js1'
			C_Js1 = boundaryBasedContentExtractorItem0001_4.getResultText();
			log("<<< C_Js1 = " + C_Js1);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_Js1!= null && C_Js1.trim().length() == 0)
			{
				C_Js1 = "";
				log("runtime note: the extraction of a new value for the variable 'C_Js1' ends up with an empty string - a substitute value was set");
				log("<<< C_Js1 = " + C_Js1);
			}
		}
		catch (Exception e) { C_Js1 = null; log(e); }
		if (C_Js1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_Js1' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_SrvID'
			C_SrvID = boundaryBasedHeaderExtractorItem0001_2.getResultText();
			log("<<< C_SrvID = " + C_SrvID);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_SrvID!= null && C_SrvID.trim().length() == 0)
			{
				C_SrvID = "";
				log("runtime note: the extraction of a new value for the variable 'C_SrvID' ends up with an empty string - a substitute value was set");
				log("<<< C_SrvID = " + C_SrvID);
			}
		}
		catch (Exception e) { C_SrvID = null; log(e); }
		if (C_SrvID == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_SrvID' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_Css4'
			C_Css4 = boundaryBasedContentExtractorItem0001_5.getResultText();
			log("<<< C_Css4 = " + C_Css4);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_Css4!= null && C_Css4.trim().length() == 0)
			{
				C_Css4 = "";
				log("runtime note: the extraction of a new value for the variable 'C_Css4' ends up with an empty string - a substitute value was set");
				log("<<< C_Css4 = " + C_Css4);
			}
		}
		catch (Exception e) { C_Css4 = null; log(e); }
		if (C_Css4 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_Css4' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_Css3'
			C_Css3 = boundaryBasedContentExtractorItem0001_6.getResultText();
			log("<<< C_Css3 = " + C_Css3);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_Css3!= null && C_Css3.trim().length() == 0)
			{
				C_Css3 = "";
				log("runtime note: the extraction of a new value for the variable 'C_Css3' ends up with an empty string - a substitute value was set");
				log("<<< C_Css3 = " + C_Css3);
			}
		}
		catch (Exception e) { C_Css3 = null; log(e); }
		if (C_Css3 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_Css3' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_Css2'
			C_Css2 = boundaryBasedContentExtractorItem0001_7.getResultText();
			log("<<< C_Css2 = " + C_Css2);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_Css2!= null && C_Css2.trim().length() == 0)
			{
				C_Css2 = "";
				log("runtime note: the extraction of a new value for the variable 'C_Css2' ends up with an empty string - a substitute value was set");
				log("<<< C_Css2 = " + C_Css2);
			}
		}
		catch (Exception e) { C_Css2 = null; log(e); }
		if (C_Css2 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_Css2' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_Css1'
			C_Css1 = boundaryBasedContentExtractorItem0001_8.getResultText();
			log("<<< C_Css1 = " + C_Css1);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_Css1!= null && C_Css1.trim().length() == 0)
			{
				C_Css1 = "";
				log("runtime note: the extraction of a new value for the variable 'C_Css1' ends up with an empty string - a substitute value was set");
				log("<<< C_Css1 = " + C_Css1);
			}
		}
		catch (Exception e) { C_Css1 = null; log(e); }
		if (C_Css1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_Css1' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_JSVersion'
			C_JSVersion = boundaryBasedContentExtractorItem0001_9.getResultText();
			log("<<< C_JSVersion = " + C_JSVersion);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_JSVersion!= null && C_JSVersion.trim().length() == 0)
			{
				C_JSVersion = "";
				log("runtime note: the extraction of a new value for the variable 'C_JSVersion' ends up with an empty string - a substitute value was set");
				log("<<< C_JSVersion = " + C_JSVersion);
			}
		}
		catch (Exception e) { C_JSVersion = null; log(e); }
		if (C_JSVersion == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_JSVersion' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [2] <- WEB ADMIN Index 2 ---
		String requestProt0002 = "https";
		String requestHost0002 = "teck-test.wfsaas.ca";
		int    requestPort0002 = 443;
		String requestFile0002 = "/workforce/css/wfs.css.vmc" +
				"?locale=ENGLISH_US" +
				"&theme=TECK_TEST_THEME" +
				"&ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0002 = Lib.replaceTextPattern(requestFile0002, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0002 = "GET " + requestFile0002 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0002, requestHost0002, requestPort0002, requestHeader0002, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0002 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 4307
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [2] <- Index 2
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [3] <- WEB ADMIN Index 3 ---
		String requestProt0003 = "https";
		String requestHost0003 = "teck-test.wfsaas.ca";
		int    requestPort0003 = 443;
		String requestFile0003 = "/workforce/css/classicTheme.css.vmc" +
				"?locale=ENGLISH_US" +
				"&theme=TECK_TEST_THEME" +
				"&ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0003 = Lib.replaceTextPattern(requestFile0003, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0003 = "GET " + requestFile0003 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0003, requestHost0003, requestPort0003, requestHeader0003, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0003 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 185
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [3] <- Index 3
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [4] <- WEB ADMIN Index 4 ---
		String requestProt0004 = "https";
		String requestHost0004 = "teck-test.wfsaas.ca";
		int    requestPort0004 = 443;
		String requestFile0004 = "/workforce/bundles/coreCss/css/coreCss_esQe-5DQ6Xg90oucA54hRg==.css?";
		requestFile0004 = Lib.replaceTextPattern(requestFile0004, "esQe-5DQ6Xg90oucA54hRg==", C_Css2, 0);		// search and replace request file fragment "esQe-5DQ6Xg90oucA54hRg==" with variable 'C_Css2' on all occurrences

		String requestHeader0004 = "GET " + requestFile0004 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0004, requestHost0004, requestPort0004, requestHeader0004, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0004 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 14897
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [4] <- Index 4
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [5] <- WEB ADMIN Index 5 ---
		String requestProt0005 = "https";
		String requestHost0005 = "teck-test.wfsaas.ca";
		int    requestPort0005 = 443;
		String requestFile0005 = "/workforce/bundles/bannerComponentsCss/bannerComponentsCss_4-YBt7Ul0Jtwc-BMRzKKAw==.css?";
		requestFile0005 = Lib.replaceTextPattern(requestFile0005, "4-YBt7Ul0Jtwc-BMRzKKAw==", C_Css3, 0);		// search and replace request file fragment "4-YBt7Ul0Jtwc-BMRzKKAw==" with variable 'C_Css3' on all occurrences

		String requestHeader0005 = "GET " + requestFile0005 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0005, requestHost0005, requestPort0005, requestHeader0005, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0005 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2336
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [5] <- Index 5
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [6] <- WEB ADMIN Index 6 ---
		String requestProt0006 = "https";
		String requestHost0006 = "teck-test.wfsaas.ca";
		int    requestPort0006 = 443;
		String requestFile0006 = "/workforce/css/customCssOverrides.css.vmc" +
				"?locale=ENGLISH_US" +
				"&theme=TECK_TEST_THEME" +
				"&ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0006 = Lib.replaceTextPattern(requestFile0006, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0006 = "GET " + requestFile0006 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0006, requestHost0006, requestPort0006, requestHeader0006, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0006 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 52
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [6] <- Index 6
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [7] <- WEB ADMIN Index 7 ---
		String requestProt0007 = "https";
		String requestHost0007 = "teck-test.wfsaas.ca";
		int    requestPort0007 = 443;
		String requestFile0007 = "/workforce/bundles/extJsCss/css/extjs/css/extJsCss_UYrXPxvMEZahQpGllOBlsw==.css?";
		requestFile0007 = Lib.replaceTextPattern(requestFile0007, "UYrXPxvMEZahQpGllOBlsw==", C_Css1, 0);		// search and replace request file fragment "UYrXPxvMEZahQpGllOBlsw==" with variable 'C_Css1' on all occurrences

		String requestHeader0007 = "GET " + requestFile0007 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0007, requestHost0007, requestPort0007, requestHeader0007, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0007 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 20890
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [7] <- Index 7
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [8] <- WEB ADMIN Index 8 ---
		String requestProt0008 = "https";
		String requestHost0008 = "teck-test.wfsaas.ca";
		int    requestPort0008 = 443;
		String requestFile0008 = "/workforce/css/login.css.vmc" +
				"?locale=ENGLISH_US" +
				"&theme=TECK_TEST_THEME" +
				"&ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0008 = Lib.replaceTextPattern(requestFile0008, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0008 = "GET " + requestFile0008 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0008, requestHost0008, requestPort0008, requestHeader0008, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0008 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1654
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [8] <- Index 8
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [9] <- WEB ADMIN Index 9 ---
		String requestProt0009 = "https";
		String requestHost0009 = "teck-test.wfsaas.ca";
		int    requestPort0009 = 443;
		String requestFile0009 = "/workforce/bundles/systemTimeSwitcherCss/systemTimeSwitcherCss_RAaLx5BiSVF8afAoHRpJXA==.css?";
		requestFile0009 = Lib.replaceTextPattern(requestFile0009, "RAaLx5BiSVF8afAoHRpJXA==", C_Css4, 0);		// search and replace request file fragment "RAaLx5BiSVF8afAoHRpJXA==" with variable 'C_Css4' on all occurrences

		String requestHeader0009 = "GET " + requestFile0009 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0009, requestHost0009, requestPort0009, requestHeader0009, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0009 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 607
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [9] <- Index 9
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [10] <- WEB ADMIN Index 10 ---
		String requestProt0010 = "https";
		String requestHost0010 = "teck-test.wfsaas.ca";
		int    requestPort0010 = 443;
		String requestFile0010 = "/workforce/bundles/coreJs/coreJs_9rJjGav1J1aZeFzV66M71w==.js?";
		requestFile0010 = Lib.replaceTextPattern(requestFile0010, "9rJjGav1J1aZeFzV66M71w==", C_Js1, 0);		// search and replace request file fragment "9rJjGav1J1aZeFzV66M71w==" with variable 'C_Js1' on all occurrences

		String requestHeader0010 = "GET " + requestFile0010 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0010, requestHost0010, requestPort0010, requestHeader0010, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0010 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 219058
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [10] <- Index 10
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [11] <- WEB ADMIN Index 11 ---
		String requestProt0011 = "https";
		String requestHost0011 = "teck-test.wfsaas.ca";
		int    requestPort0011 = 443;
		String requestFile0011 = "/workforce/bundles/extJs/extJs_Xzv2wCHpbAXN85_joi_s9Q==.js?";
		requestFile0011 = Lib.replaceTextPattern(requestFile0011, "Xzv2wCHpbAXN85_joi_s9Q==", C_Js2, 0);		// search and replace request file fragment "Xzv2wCHpbAXN85_joi_s9Q==" with variable 'C_Js2' on all occurrences

		String requestHeader0011 = "GET " + requestFile0011 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0011, requestHost0011, requestPort0011, requestHeader0011, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0011 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 810626
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [11] <- Index 11
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [12] <- WEB ADMIN Index 12 ---
		String requestProt0012 = "https";
		String requestHost0012 = "teck-test.wfsaas.ca";
		int    requestPort0012 = 443;
		String requestFile0012 = "/workforce/bundles/statusListJs/statusListJs_4-0BZT30bHbEJc2jH21nxA==.js?";
		requestFile0012 = Lib.replaceTextPattern(requestFile0012, "4-0BZT30bHbEJc2jH21nxA==", C_Js3, 0);		// search and replace request file fragment "4-0BZT30bHbEJc2jH21nxA==" with variable 'C_Js3' on all occurrences

		String requestHeader0012 = "GET " + requestFile0012 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0012, requestHost0012, requestPort0012, requestHeader0012, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0012 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1040
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [12] <- Index 12
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [13] <- WEB ADMIN Index 13 ---
		String requestProt0013 = "https";
		String requestHost0013 = "teck-test.wfsaas.ca";
		int    requestPort0013 = 443;
		String requestFile0013 = "/workforce/bundles/bannerComponentsJs/bannerComponentsJs_LrGfo28H9cI42m61vkfacA==.js?";
		requestFile0013 = Lib.replaceTextPattern(requestFile0013, "LrGfo28H9cI42m61vkfacA==", C_js4, 0);		// search and replace request file fragment "LrGfo28H9cI42m61vkfacA==" with variable 'C_js4' on all occurrences

		String requestHeader0013 = "GET " + requestFile0013 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0013, requestHost0013, requestPort0013, requestHeader0013, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0013 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 32267
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [13] <- Index 13
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [14] <- WEB ADMIN Index 14 ---
		String requestProt0014 = "https";
		String requestHost0014 = "teck-test.wfsaas.ca";
		int    requestPort0014 = 443;
		String requestFile0014 = "/workforce/JSLib/wfs/LogonLocaleSwitcher.js" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0014 = Lib.replaceTextPattern(requestFile0014, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0014 = "GET " + requestFile0014 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0014, requestHost0014, requestPort0014, requestHeader0014, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0014 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4202
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [14] <- Index 14
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [15] <- WEB ADMIN Index 15 ---
		String requestProt0015 = "https";
		String requestHost0015 = "teck-test.wfsaas.ca";
		int    requestPort0015 = 443;
		String requestFile0015 = "/workforce/bundles/systemTimeSwitcherJs/systemTimeSwitcherJs_XF6lwlTeAzHJZPC77RHyCA==.js?";
		String requestHeader0015 = "GET " + requestFile0015 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0015, requestHost0015, requestPort0015, requestHeader0015, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0015 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 35311
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [15] <- Index 15
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [16] <- WEB ADMIN Index 16 ---
		String requestProt0016 = "https";
		String requestHost0016 = "teck-test.wfsaas.ca";
		int    requestPort0016 = 443;
		String requestFile0016 = "/workforce/css/custom-boxes.css.vmc" +
				"?locale=ENGLISH_US" +
				"&theme=TECK_TEST_THEME" +
				"&ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0016 = Lib.replaceTextPattern(requestFile0016, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0016 = "GET " + requestFile0016 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0016, requestHost0016, requestPort0016, requestHeader0016, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0016 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 788
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [16] <- Index 16
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [17] <- WEB ADMIN Index 17 ---
		String requestProt0017 = "https";
		String requestHost0017 = "teck-test.wfsaas.ca";
		int    requestPort0017 = 443;
		String requestFile0017 = "/workforce/css/wfsBanner.css.vmc" +
				"?locale=ENGLISH_US" +
				"&theme=TECK_TEST_THEME" +
				"&ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0017 = Lib.replaceTextPattern(requestFile0017, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0017 = "GET " + requestFile0017 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0017, requestHost0017, requestPort0017, requestHeader0017, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0017 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2637
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [17] <- Index 17
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [18] <- WEB ADMIN Index 18 ---
		String requestProt0018 = "https";
		String requestHost0018 = "teck-test.wfsaas.ca";
		int    requestPort0018 = 443;
		String requestFile0018 = "/workforce/UITheme.do" +
				"?action=getLogo" +
				"&theme=TECK_TEST_THEME" +
				"&ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0018 = Lib.replaceTextPattern(requestFile0018, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0018 = "GET " + requestFile0018 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0018, requestHost0018, requestPort0018, requestHeader0018, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0018 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 3535
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [18] <- Index 18
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [19] <- WEB ADMIN Index 19 ---
		String requestProt0019 = "https";
		String requestHost0019 = "teck-test.wfsaas.ca";
		int    requestPort0019 = 443;
		String requestFile0019 = "/workforce/images/clear.gif" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0019 = Lib.replaceTextPattern(requestFile0019, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0019 = "GET " + requestFile0019 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0019, requestHost0019, requestPort0019, requestHeader0019, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0019 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 48
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [19] <- Index 19
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [20] <- WEB ADMIN Index 20 ---
		String requestProt0020 = "https";
		String requestHost0020 = "teck-test.wfsaas.ca";
		int    requestPort0020 = 443;
		String requestFile0020 = "/workforce/css/fonts/opensans/OpenSans-Regular.woff" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0020 = Lib.replaceTextPattern(requestFile0020, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0020 = "GET " + requestFile0020 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0020, requestHost0020, requestPort0020, requestHeader0020, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("esQe-5DQ6Xg90oucA54hRg==", C_Css2);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0020 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF", header text fragment = [verification disabled], recorded content size = 63712
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF", null, null);		// Test [20] <- Index 20
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1_1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #1 (fragment 2 of 2)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [21] <- WEB ADMIN Index 21 ---
		String requestProt0021 = "https";
		String requestHost0021 = "teck-test.wfsaas.ca";
		int    requestPort0021 = 443;
		String requestFile0021 = "/workforce/css/fonts/opensans/OpenSans-Semibold.woff" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0021 = Lib.replaceTextPattern(requestFile0021, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0021 = "GET " + requestFile0021 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0021, requestHost0021, requestPort0021, requestHeader0021, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("esQe-5DQ6Xg90oucA54hRg==", C_Css2);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0021 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF", header text fragment = [verification disabled], recorded content size = 69888
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF", null, null);		// Test [21] <- Index 21
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [22] <- WEB ADMIN Index 22 ---
		String requestProt0022 = "https";
		String requestHost0022 = "teck-test.wfsaas.ca";
		int    requestPort0022 = 443;
		String requestFile0022 = "/workforce/css/fonts/opensans/OpenSans-Bold.woff" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0022 = Lib.replaceTextPattern(requestFile0022, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0022 = "GET " + requestFile0022 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0022, requestHost0022, requestPort0022, requestHeader0022, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("esQe-5DQ6Xg90oucA54hRg==", C_Css2);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0022 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF", header text fragment = [verification disabled], recorded content size = 14192
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF", null, null);		// Test [22] <- Index 22
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [23] <- WEB ADMIN Index 23 ---
		String requestProt0023 = "https";
		String requestHost0023 = "teck-test.wfsaas.ca";
		int    requestPort0023 = 443;
		String requestFile0023 = "/workforce/UITheme.do" +
				"?action=getMobileHomescreenIcon" +
				"&theme=TECK_TEST_THEME" +
				"&ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0023 = Lib.replaceTextPattern(requestFile0023, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0023 = "GET " + requestFile0023 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0023, requestHost0023, requestPort0023, requestHeader0023, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0023 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 7378
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [23] <- Index 23
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [24] <- WEB ADMIN Index 24 ---
		String requestProt0024 = "https";
		String requestHost0024 = "teck-test.wfsaas.ca";
		int    requestPort0024 = 443;
		String requestFile0024 = "/workforce/UITheme.do" +
				"?action=getFavicon" +
				"&theme=TECK_TEST_THEME" +
				"&ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0024 = Lib.replaceTextPattern(requestFile0024, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0024 = "GET " + requestFile0024 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0024, requestHost0024, requestPort0024, requestHeader0024, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0024 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/X-ICON", header text fragment = [verification disabled], recorded content size = 4414
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/X-ICON", null, null);		// Test [24] <- Index 24
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #1_1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #2: Login
		// # --------------



		// --- HTTP REQUEST: Test [26] <- WEB ADMIN Index 26 ---
		String requestProt0026 = "https";
		String requestHost0026 = "teck-test.wfsaas.ca";
		int    requestPort0026 = 443;
		String requestFile0026 = "/workforce/Desktop.do";
		String requestContent0026 = 
				"action=login" +
				"&username=" + java.net.URLEncoder.encode(P_UserID) +		// recorded value = TSYVENKY
				"&password=" + java.net.URLEncoder.encode(P_Password) +		// recorded value = Password123%40
				"&Submit=Log+In";
		String requestHeader0026 = "POST " + requestFile0026 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0026.length() + "\r\n" + 		// Content-Length: 68
				"Origin: https://teck-test.wfsaas.ca\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0026, requestHost0026, requestPort0026, requestHeader0026, requestContent0026.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("D7C090CBFAF2C1070916222C880817CB", C_JsessionID1);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0026 = null;		// support garbage collector to reduce memory
		requestContent0026 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [26] <- Index 26
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getContentString());

		boundaryBasedExtractor.extractText();
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getHeaderString());

		// setup var extractor for 'C_JsessionID2'
		BoundaryBasedExtractorItem boundaryBasedHeaderExtractorItem0026_1 = new BoundaryBasedExtractorItem( "JSESSIONID=" , ";",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedHeaderExtractorItem0026_1);

		boundaryBasedExtractor.extractText();
		try
		{
			// extract var 'C_JsessionID2'
			C_JsessionID2 = boundaryBasedHeaderExtractorItem0026_1.getResultText();
			log("<<< C_JsessionID2 = " + C_JsessionID2);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_JsessionID2!= null && C_JsessionID2.trim().length() == 0)
			{
				C_JsessionID2 = "";
				log("runtime note: the extraction of a new value for the variable 'C_JsessionID2' ends up with an empty string - a substitute value was set");
				log("<<< C_JsessionID2 = " + C_JsessionID2);
			}
		}
		catch (Exception e) { C_JsessionID2 = null; log(e); }
		if (C_JsessionID2 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_JsessionID2' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [27] <- WEB ADMIN Index 27 ---
		String requestProt0027 = "https";
		String requestHost0027 = "teck-test.wfsaas.ca";
		int    requestPort0027 = 443;
		String requestFile0027 = "/workforce/Home.do" +
				"?action=start";
		String requestHeader0027 = "GET " + requestFile0027 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0027, requestHost0027, requestPort0027, requestHeader0027, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0027 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 5481
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [27] <- Index 27
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		contentTokenExtractor = new ContentTokenExtractor(testURL.getContentString());

		// setup var extractor for 'C_CsrfToken1'
		ContentTokenExtractorItem contentTokenExtractorItem0027_1 = new ContentTokenExtractorItem(";CsrfTokenManager.TOKEN_VALUE", "\t\n\r \"(),={}", 1);
		contentTokenExtractor.addTokenExtractorItem(contentTokenExtractorItem0027_1);

		contentTokenExtractor.extractTokens();
		try
		{
			// extract var 'C_CsrfToken1'
			C_CsrfToken1 = contentTokenExtractorItem0027_1.getResultToken();
			log("<<< C_CsrfToken1 = " + C_CsrfToken1);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_CsrfToken1!= null && C_CsrfToken1.trim().length() == 0)
			{
				C_CsrfToken1 = "";
				log("runtime note: the extraction of a new value for the variable 'C_CsrfToken1' ends up with an empty string - a substitute value was set");
				log("<<< C_CsrfToken1 = " + C_CsrfToken1);
			}
		}
		catch (Exception e) { C_CsrfToken1 = null; log(e); }
		if (C_CsrfToken1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_CsrfToken1' from content token pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [28] <- WEB ADMIN Index 28 ---
		String requestProt0028 = "https";
		String requestHost0028 = "teck-test.wfsaas.ca";
		int    requestPort0028 = 443;
		String requestFile0028 = "/workforce/bundles/stickyDataJs/stickyDataJs_3jXP1UX9FkiXkbtqcIdlmw==.js?";
		String requestHeader0028 = "GET " + requestFile0028 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0028, requestHost0028, requestPort0028, requestHeader0028, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0028 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 24363
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [28] <- Index 28
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [29] <- WEB ADMIN Index 29 ---
		String requestProt0029 = "https";
		String requestHost0029 = "teck-test.wfsaas.ca";
		int    requestPort0029 = 443;
		String requestFile0029 = "/workforce/GenericBanner.do" +
				"?action=Create" +
				"&theme=TECK_TEST_THEME";
		String requestHeader0029 = "GET " + requestFile0029 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0029, requestHost0029, requestPort0029, requestHeader0029, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0029 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 5741
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Log Out");		// Test [29] <- Index 29
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getContentString());

		// setup var extractor for 'C_js5'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0029_1 = new BoundaryBasedExtractorItem( "GenericBanner_" , ".js",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0029_1);

		boundaryBasedExtractor.extractText();
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getHeaderString());

		boundaryBasedExtractor.extractText();
		try
		{
			// extract var 'C_js5'
			C_js5 = boundaryBasedContentExtractorItem0029_1.getResultText();
			log("<<< C_js5 = " + C_js5);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_js5!= null && C_js5.trim().length() == 0)
			{
				C_js5 = "";
				log("runtime note: the extraction of a new value for the variable 'C_js5' ends up with an empty string - a substitute value was set");
				log("<<< C_js5 = " + C_js5);
			}
		}
		catch (Exception e) { C_js5 = null; log(e); }
		if (C_js5 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_js5' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [30] <- WEB ADMIN Index 30 ---
		String requestProt0030 = "https";
		String requestHost0030 = "teck-test.wfsaas.ca";
		int    requestPort0030 = 443;
		String requestFile0030 = "/workforce/Home.do" +
				"?action=loadDashboard";
		String requestHeader0030 = "GET " + requestFile0030 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0030, requestHost0030, requestPort0030, requestHeader0030, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0030 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 8135
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "text\": \"Edit Employee Time");		// Test [30] <- Index 30
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getContentString());

		// setup var extractor for 'C_js7'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0030_1 = new BoundaryBasedExtractorItem( "dashboardJs_" , ".js",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0030_1);

		// setup var extractor for 'C_js6'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0030_2 = new BoundaryBasedExtractorItem( "wfsGridJs_" , ".js",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0030_2);

		// setup var extractor for 'C_Css5'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0030_3 = new BoundaryBasedExtractorItem( "dashboardCss_" , ".css",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0030_3);

		boundaryBasedExtractor.extractText();
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getHeaderString());

		boundaryBasedExtractor.extractText();
		try
		{
			// extract var 'C_js7'
			C_js7 = boundaryBasedContentExtractorItem0030_1.getResultText();
			log("<<< C_js7 = " + C_js7);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_js7!= null && C_js7.trim().length() == 0)
			{
				C_js7 = "";
				log("runtime note: the extraction of a new value for the variable 'C_js7' ends up with an empty string - a substitute value was set");
				log("<<< C_js7 = " + C_js7);
			}
		}
		catch (Exception e) { C_js7 = null; log(e); }
		if (C_js7 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_js7' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_js6'
			C_js6 = boundaryBasedContentExtractorItem0030_2.getResultText();
			log("<<< C_js6 = " + C_js6);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_js6!= null && C_js6.trim().length() == 0)
			{
				C_js6 = "";
				log("runtime note: the extraction of a new value for the variable 'C_js6' ends up with an empty string - a substitute value was set");
				log("<<< C_js6 = " + C_js6);
			}
		}
		catch (Exception e) { C_js6 = null; log(e); }
		if (C_js6 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_js6' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_Css5'
			C_Css5 = boundaryBasedContentExtractorItem0030_3.getResultText();
			log("<<< C_Css5 = " + C_Css5);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_Css5!= null && C_Css5.trim().length() == 0)
			{
				C_Css5 = "";
				log("runtime note: the extraction of a new value for the variable 'C_Css5' ends up with an empty string - a substitute value was set");
				log("<<< C_Css5 = " + C_Css5);
			}
		}
		catch (Exception e) { C_Css5 = null; log(e); }
		if (C_Css5 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_Css5' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [31] <- WEB ADMIN Index 31 ---
		String requestProt0031 = "https";
		String requestHost0031 = "teck-test.wfsaas.ca";
		int    requestPort0031 = 443;
		String requestFile0031 = "/workforce/css/LocaleSwitcher.css.vmc" +
				"?locale=ENGLISH_US" +
				"&theme=TECK_TEST_THEME" +
				"&ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0031 = Lib.replaceTextPattern(requestFile0031, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0031 = "GET " + requestFile0031 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0031, requestHost0031, requestPort0031, requestHeader0031, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0031 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1272
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [31] <- Index 31
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [32] <- WEB ADMIN Index 32 ---
		String requestProt0032 = "https";
		String requestHost0032 = "teck-test.wfsaas.ca";
		int    requestPort0032 = 443;
		String requestFile0032 = "/workforce/bundles/GenericBanner/GenericBanner_BN6MhG4Dfp8jHb3jEoTxWQ==.js?";
		requestFile0032 = Lib.replaceTextPattern(requestFile0032, "BN6MhG4Dfp8jHb3jEoTxWQ==", C_js5, 0);		// search and replace request file fragment "BN6MhG4Dfp8jHb3jEoTxWQ==" with variable 'C_js5' on all occurrences

		String requestHeader0032 = "GET " + requestFile0032 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0032, requestHost0032, requestPort0032, requestHeader0032, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0032 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 100475
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [32] <- Index 32
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [33] <- WEB ADMIN Index 33 ---
		String requestProt0033 = "https";
		String requestHost0033 = "teck-test.wfsaas.ca";
		int    requestPort0033 = 443;
		String requestFile0033 = "/workforce/bundles/dashboardCss/dashboardCss_t0JfFdE0Vt7PsXbBxUieDA==.css?";
		requestFile0033 = Lib.replaceTextPattern(requestFile0033, "t0JfFdE0Vt7PsXbBxUieDA==", C_Css5, 0);		// search and replace request file fragment "t0JfFdE0Vt7PsXbBxUieDA==" with variable 'C_Css5' on all occurrences

		String requestHeader0033 = "GET " + requestFile0033 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0033, requestHost0033, requestPort0033, requestHeader0033, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0033 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 3766
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [33] <- Index 33
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [34] <- WEB ADMIN Index 34 ---
		String requestProt0034 = "https";
		String requestHost0034 = "teck-test.wfsaas.ca";
		int    requestPort0034 = 443;
		String requestFile0034 = "/workforce/bundles/wfsGridJs/wfsGridJs_7dk9WaMVUd2Q_dsMpOdMOQ==.js?";
		requestFile0034 = Lib.replaceTextPattern(requestFile0034, "7dk9WaMVUd2Q_dsMpOdMOQ==", C_js6, 0);		// search and replace request file fragment "7dk9WaMVUd2Q_dsMpOdMOQ==" with variable 'C_js6' on all occurrences

		String requestHeader0034 = "GET " + requestFile0034 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0034, requestHost0034, requestPort0034, requestHeader0034, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0034 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 14357
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [34] <- Index 34
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [35] <- WEB ADMIN Index 35 ---
		String requestProt0035 = "https";
		String requestHost0035 = "teck-test.wfsaas.ca";
		int    requestPort0035 = 443;
		String requestFile0035 = "/workforce/bundles/dashboardJs/dashboardJs_7s4v8pK9jjIEzJTEd5lFOQ==.js?";
		requestFile0035 = Lib.replaceTextPattern(requestFile0035, "7s4v8pK9jjIEzJTEd5lFOQ==", C_js7, 0);		// search and replace request file fragment "7s4v8pK9jjIEzJTEd5lFOQ==" with variable 'C_js7' on all occurrences

		String requestHeader0035 = "GET " + requestFile0035 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0035, requestHost0035, requestPort0035, requestHeader0035, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0035 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 445165
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [35] <- Index 35
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [36] <- WEB ADMIN Index 36 ---
		String requestProt0036 = "https";
		String requestHost0036 = "teck-test.wfsaas.ca";
		int    requestPort0036 = 443;
		String requestFile0036 = "/workforce/css/employeePhoto.css.vmc" +
				"?locale=ENGLISH_US" +
				"&theme=TECK_TEST_THEME" +
				"&ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0036 = Lib.replaceTextPattern(requestFile0036, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0036 = "GET " + requestFile0036 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0036, requestHost0036, requestPort0036, requestHeader0036, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0036 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1143
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [36] <- Index 36
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [37] <- WEB ADMIN Index 37 ---
		String requestProt0037 = "https";
		String requestHost0037 = "teck-test.wfsaas.ca";
		int    requestPort0037 = 443;
		String requestFile0037 = "/workforce/JSLib/EmployeePhotoUtil.js" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0037 = Lib.replaceTextPattern(requestFile0037, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0037 = "GET " + requestFile0037 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0037, requestHost0037, requestPort0037, requestHeader0037, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0037 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 19556
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [37] <- Index 37
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [38] <- WEB ADMIN Index 38 ---
		String requestProt0038 = "https";
		String requestHost0038 = "teck-test.wfsaas.ca";
		int    requestPort0038 = 443;
		String requestFile0038 = "/workforce/css/fonts/wfsicons/wfsicons.woff" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0038 = Lib.replaceTextPattern(requestFile0038, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0038 = "GET " + requestFile0038 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0038, requestHost0038, requestPort0038, requestHeader0038, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("esQe-5DQ6Xg90oucA54hRg==", C_Css2);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0038 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF", header text fragment = [verification disabled], recorded content size = 39200
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF", null, null);		// Test [38] <- Index 38
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [39] <- WEB ADMIN Index 39 ---
		String requestProt0039 = "https";
		String requestHost0039 = "teck-test.wfsaas.ca";
		int    requestPort0039 = 443;
		String requestFile0039 = "/workforce/bundles/extJsCss/css/extjs/images/default/qtip/tip-anchor-sprite.gif";
		String requestHeader0039 = "GET " + requestFile0039 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0039, requestHost0039, requestPort0039, requestHeader0039, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("UYrXPxvMEZahQpGllOBlsw==", C_Css1);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0039 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 951
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [39] <- Index 39
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [40] <- WEB ADMIN Index 40 ---
		String requestProt0040 = "https";
		String requestHost0040 = "teck-test.wfsaas.ca";
		int    requestPort0040 = 443;
		String requestFile0040 = "/workforce/images/dropdown_arrow.png" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0040 = Lib.replaceTextPattern(requestFile0040, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0040 = "GET " + requestFile0040 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0040, requestHost0040, requestPort0040, requestHeader0040, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("1030101427", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0040 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 395
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [40] <- Index 40
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [41] <- WEB ADMIN Index 41 ---
		String requestProt0041 = "https";
		String requestHost0041 = "teck-test.wfsaas.ca";
		int    requestPort0041 = 443;
		String requestFile0041 = "/workforce/images/arrow.gif" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0041 = Lib.replaceTextPattern(requestFile0041, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0041 = "GET " + requestFile0041 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0041, requestHost0041, requestPort0041, requestHeader0041, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("1030101427", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0041 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 833
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [41] <- Index 41
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [42] <- WEB ADMIN Index 42 ---
		String requestProt0042 = "https";
		String requestHost0042 = "teck-test.wfsaas.ca";
		int    requestPort0042 = 443;
		String requestFile0042 = "/workforce/css/fonts/opensans/OpenSans-Italic.woff" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0042 = Lib.replaceTextPattern(requestFile0042, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0042 = "GET " + requestFile0042 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0042, requestHost0042, requestPort0042, requestHeader0042, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("esQe-5DQ6Xg90oucA54hRg==", C_Css2);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0042 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF", header text fragment = [verification disabled], recorded content size = 76104
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF", null, null);		// Test [42] <- Index 42
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [43] <- WEB ADMIN Index 43 ---
		String requestProt0043 = "https";
		String requestHost0043 = "teck-test.wfsaas.ca";
		int    requestPort0043 = 443;
		String requestFile0043 = "/workforce/JspRedirect.do" +
				"?action=BrowserPerformance";
		String requestHeader0043 = "GET " + requestFile0043 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0043, requestHost0043, requestPort0043, requestHeader0043, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0043 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 4066
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [43] <- Index 43
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [44] <- WEB ADMIN Index 44 ---
		String requestProt0044 = "https";
		String requestHost0044 = "teck-test.wfsaas.ca";
		int    requestPort0044 = 443;
		String requestFile0044 = "/workforce/JSLib/BrowserPerformance.js" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0044 = Lib.replaceTextPattern(requestFile0044, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0044 = "GET " + requestFile0044 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0044, requestHost0044, requestPort0044, requestHeader0044, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0044 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 8834
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [44] <- Index 44
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [45] <- WEB ADMIN Index 45 ---
		String requestProt0045 = "https";
		String requestHost0045 = "teck-test.wfsaas.ca";
		int    requestPort0045 = 443;
		String requestFile0045 = "/workforce/images/star_disabled.png" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0045 = Lib.replaceTextPattern(requestFile0045, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0045 = "GET " + requestFile0045 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0045, requestHost0045, requestPort0045, requestHeader0045, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("t0JfFdE0Vt7PsXbBxUieDA==", C_Css5);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0045 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 428
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [45] <- Index 45
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #2 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #3.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #3: ViewReports
		// # --------------------



		// --- HTTP REQUEST: Test [47] <- WEB ADMIN Index 47 ---
		String requestProt0047 = "https";
		String requestHost0047 = "teck-test.wfsaas.ca";
		int    requestPort0047 = 443;
		String requestFile0047 = "/workforce/Reports.do";
		String requestHeader0047 = "GET " + requestFile0047 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0047, requestHost0047, requestPort0047, requestHeader0047, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0047 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 7027
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "anAdministrateScheduledReports");		// Test [47] <- Index 47
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getContentString());

		// setup var extractor for 'C_js9'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0047_1 = new BoundaryBasedExtractorItem( "reportCss_" , ".css",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0047_1);

		// setup var extractor for 'C_js8'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0047_2 = new BoundaryBasedExtractorItem( "reportJs_" , ".js",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0047_2);

		boundaryBasedExtractor.extractText();
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getHeaderString());

		boundaryBasedExtractor.extractText();
		try
		{
			// extract var 'C_js9'
			C_js9 = boundaryBasedContentExtractorItem0047_1.getResultText();
			log("<<< C_js9 = " + C_js9);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_js9!= null && C_js9.trim().length() == 0)
			{
				C_js9 = "";
				log("runtime note: the extraction of a new value for the variable 'C_js9' ends up with an empty string - a substitute value was set");
				log("<<< C_js9 = " + C_js9);
			}
		}
		catch (Exception e) { C_js9 = null; log(e); }
		if (C_js9 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_js9' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_js8'
			C_js8 = boundaryBasedContentExtractorItem0047_2.getResultText();
			log("<<< C_js8 = " + C_js8);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_js8!= null && C_js8.trim().length() == 0)
			{
				C_js8 = "";
				log("runtime note: the extraction of a new value for the variable 'C_js8' ends up with an empty string - a substitute value was set");
				log("<<< C_js8 = " + C_js8);
			}
		}
		catch (Exception e) { C_js8 = null; log(e); }
		if (C_js8 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_js8' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [48] <- WEB ADMIN Index 48 ---
		String requestProt0048 = "https";
		String requestHost0048 = "teck-test.wfsaas.ca";
		int    requestPort0048 = 443;
		String requestFile0048 = "/workforce/bundles/reportJs/reportJs_OgWkr-RoWP7yQhiJxx_9Dw==.js?";
		requestFile0048 = Lib.replaceTextPattern(requestFile0048, "OgWkr-RoWP7yQhiJxx_9Dw==", C_js8, 0);		// search and replace request file fragment "OgWkr-RoWP7yQhiJxx_9Dw==" with variable 'C_js8' on all occurrences

		String requestHeader0048 = "GET " + requestFile0048 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0048, requestHost0048, requestPort0048, requestHeader0048, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0048 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 291627
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [48] <- Index 48
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [49] <- WEB ADMIN Index 49 ---
		String requestProt0049 = "https";
		String requestHost0049 = "teck-test.wfsaas.ca";
		int    requestPort0049 = 443;
		String requestFile0049 = "/workforce/bundles/reportCss/reportCss_z5Z0vHts1o1LxRIq6UVcsQ==.css?";
		requestFile0049 = Lib.replaceTextPattern(requestFile0049, "z5Z0vHts1o1LxRIq6UVcsQ==", C_js9, 0);		// search and replace request file fragment "z5Z0vHts1o1LxRIq6UVcsQ==" with variable 'C_js9' on all occurrences

		String requestHeader0049 = "GET " + requestFile0049 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0049, requestHost0049, requestPort0049, requestHeader0049, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0049 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 5917
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [49] <- Index 49
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [50] <- WEB ADMIN Index 50 ---
		String requestProt0050 = "https";
		String requestHost0050 = "teck-test.wfsaas.ca";
		int    requestPort0050 = 443;
		String requestFile0050 = "/workforce/images/find.png" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0050 = Lib.replaceTextPattern(requestFile0050, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0050 = "GET " + requestFile0050 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0050, requestHost0050, requestPort0050, requestHeader0050, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0050 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 681
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [50] <- Index 50
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [51] <- WEB ADMIN Index 51 ---
		String requestProt0051 = "https";
		String requestHost0051 = "teck-test.wfsaas.ca";
		int    requestPort0051 = 443;
		String requestFile0051 = "/workforce/images/refresh.png" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0051 = Lib.replaceTextPattern(requestFile0051, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0051 = "GET " + requestFile0051 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0051, requestHost0051, requestPort0051, requestHeader0051, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0051 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 977
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [51] <- Index 51
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [52] <- WEB ADMIN Index 52 ---
		String requestProt0052 = "https";
		String requestHost0052 = "teck-test.wfsaas.ca";
		int    requestPort0052 = 443;
		String requestFile0052 = "/workforce/images/colnav/folder_blue.png" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0052 = Lib.replaceTextPattern(requestFile0052, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0052 = "GET " + requestFile0052 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0052, requestHost0052, requestPort0052, requestHeader0052, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("z5Z0vHts1o1LxRIq6UVcsQ==", C_js9);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0052 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 827
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [52] <- Index 52
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [53] <- WEB ADMIN Index 53 ---
		String requestProt0053 = "https";
		String requestHost0053 = "teck-test.wfsaas.ca";
		int    requestPort0053 = 443;
		String requestFile0053 = "/workforce/images/colnav/arrow_gray.png" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0053 = Lib.replaceTextPattern(requestFile0053, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0053 = "GET " + requestFile0053 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0053, requestHost0053, requestPort0053, requestHeader0053, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("z5Z0vHts1o1LxRIq6UVcsQ==", C_js9);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0053 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 454
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [53] <- Index 53
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [54] <- WEB ADMIN Index 54 ---
		String requestProt0054 = "https";
		String requestHost0054 = "teck-test.wfsaas.ca";
		int    requestPort0054 = 443;
		String requestFile0054 = "/workforce/images/clear.gif";
		String requestHeader0054 = "GET " + requestFile0054 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0054, requestHost0054, requestPort0054, requestHeader0054, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0054 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 48
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [54] <- Index 54
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [55] <- WEB ADMIN Index 55 ---
		String requestProt0055 = "https";
		String requestHost0055 = "teck-test.wfsaas.ca";
		int    requestPort0055 = 443;
		String requestFile0055 = "/workforce/bundles/extJsCss/css/extjs/images/default/dd/drop-no.gif";
		String requestHeader0055 = "GET " + requestFile0055 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0055, requestHost0055, requestPort0055, requestHeader0055, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("UYrXPxvMEZahQpGllOBlsw==", C_Css1);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0055 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 949
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [55] <- Index 55
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [56] <- WEB ADMIN Index 56 ---
		String requestProt0056 = "https";
		String requestHost0056 = "teck-test.wfsaas.ca";
		int    requestPort0056 = 443;
		String requestFile0056 = "/workforce/bundles/extJsCss/css/extjs/images/default/grid/col-move-top.gif";
		String requestHeader0056 = "GET " + requestFile0056 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0056, requestHost0056, requestPort0056, requestHeader0056, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("UYrXPxvMEZahQpGllOBlsw==", C_Css1);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0056 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 869
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [56] <- Index 56
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [57] <- WEB ADMIN Index 57 ---
		String requestProt0057 = "https";
		String requestHost0057 = "teck-test.wfsaas.ca";
		int    requestPort0057 = 443;
		String requestFile0057 = "/workforce/bundles/extJsCss/css/extjs/images/default/grid/col-move-bottom.gif";
		String requestHeader0057 = "GET " + requestFile0057 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0057, requestHost0057, requestPort0057, requestHeader0057, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("UYrXPxvMEZahQpGllOBlsw==", C_Css1);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0057 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 868
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [57] <- Index 57
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [58] <- WEB ADMIN Index 58 ---
		String requestProt0058 = "https";
		String requestHost0058 = "teck-test.wfsaas.ca";
		int    requestPort0058 = 443;
		String requestFile0058 = "/workforce/UserPreferences.do" +
				"?action=set";
		String requestContent0058 = 
				"trxn=%7B%22ReportNavigationPanel.Height%22%3A559%7D" +
				"&loaderTimestamp=1573601634008" +
				"&transactionID=1" +
				"&HttpJsonResponse=true" +
				"&csrfToken=" + C_CsrfToken1;		// recorded value = 1A1573601613498A923882780
		requestContent0058 = Lib.replaceTextPattern(requestContent0058, "1A1573601613498A923882780", C_CsrfToken1, 0);		// search and replace content fragment "1A1573601613498A923882780" with variable 'C_CsrfToken1' on all occurrences

		byte[] requestContentBinary0058 = requestContent0058.getBytes("UTF-8");
		String requestHeader0058 = "POST " + requestFile0058 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0058.length + "\r\n" + 		// Content-Length: 156
				"Origin: https://teck-test.wfsaas.ca\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0058, requestHost0058, requestPort0058, requestHeader0058, requestContentBinary0058, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0058 = null;		// support garbage collector to reduce memory
		requestContent0058 = null;		// support garbage collector to reduce memory
		requestContentBinary0058 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 88
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "{\"success\": true,\"preferences\":");		// Test [58] <- Index 58
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #3 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #4.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #4: Reports_AssignmentWorkGroupDetail
		// # ------------------------------------------



		// --- HTTP REQUEST: Test [60] <- WEB ADMIN Index 60 ---
		String requestProt0060 = "https";
		String requestHost0060 = "teck-test.wfsaas.ca";
		int    requestPort0060 = 443;
		String requestFile0060 = "/workforce/images/star_grey.png" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0060 = Lib.replaceTextPattern(requestFile0060, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0060 = "GET " + requestFile0060 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0060, requestHost0060, requestPort0060, requestHeader0060, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("z5Z0vHts1o1LxRIq6UVcsQ==", C_js9);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0060 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 755
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [60] <- Index 60
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [61] <- WEB ADMIN Index 61 ---
		String requestProt0061 = "https";
		String requestHost0061 = "teck-test.wfsaas.ca";
		int    requestPort0061 = 443;
		String requestFile0061 = "/workforce/images/colnav/document_chart.png" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0061 = Lib.replaceTextPattern(requestFile0061, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0061 = "GET " + requestFile0061 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0061, requestHost0061, requestPort0061, requestHeader0061, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("z5Z0vHts1o1LxRIq6UVcsQ==", C_js9);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0061 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 696
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [61] <- Index 61
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [62] <- WEB ADMIN Index 62 ---
		String requestProt0062 = "https";
		String requestHost0062 = "teck-test.wfsaas.ca";
		int    requestPort0062 = 443;
		String requestFile0062 = "/workforce/Reports.do" +
				"?action=loadReportPolicy";
		String requestContent0062 = 
				"reportPolicyId=STD_ASGNMT_GRP_DETAIL" +
				"&loaderTimestamp=1573601801459" +
				"&transactionID=2" +
				"&HttpJsonResponse=true" +
				"&csrfToken=" + C_CsrfToken1;		// recorded value = 1A1573601613498A923882780
		requestContent0062 = Lib.replaceTextPattern(requestContent0062, "1A1573601613498A923882780", C_CsrfToken1, 0);		// search and replace content fragment "1A1573601613498A923882780" with variable 'C_CsrfToken1' on all occurrences

		byte[] requestContentBinary0062 = requestContent0062.getBytes("UTF-8");
		String requestHeader0062 = "POST " + requestFile0062 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0062.length + "\r\n" + 		// Content-Length: 141
				"Origin: https://teck-test.wfsaas.ca\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0062, requestHost0062, requestPort0062, requestHeader0062, requestContentBinary0062, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0062 = null;		// support garbage collector to reduce memory
		requestContent0062 = null;		// support garbage collector to reduce memory
		requestContentBinary0062 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 1797
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "DeliveryFormats\":[\"REPORT_FORMAT.PDF\",\"REPORT_FORMAT.XLS\",\"REPORT_FORMAT.CSV\",\"REPORT_FORMAT.HTML\"]}");		// Test [62] <- Index 62
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [63] <- WEB ADMIN Index 63 ---
		String requestProt0063 = "https";
		String requestHost0063 = "teck-test.wfsaas.ca";
		int    requestPort0063 = 443;
		String requestFile0063 = "/workforce/images/media_play_green.png" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0063 = Lib.replaceTextPattern(requestFile0063, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0063 = "GET " + requestFile0063 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0063, requestHost0063, requestPort0063, requestHeader0063, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("z5Z0vHts1o1LxRIq6UVcsQ==", C_js9);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0063 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 671
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [63] <- Index 63
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [64] <- WEB ADMIN Index 64 ---
		String requestProt0064 = "https";
		String requestHost0064 = "teck-test.wfsaas.ca";
		int    requestPort0064 = 443;
		String requestFile0064 = "/workforce/images/calendar.png" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0064 = Lib.replaceTextPattern(requestFile0064, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0064 = "GET " + requestFile0064 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0064, requestHost0064, requestPort0064, requestHeader0064, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("z5Z0vHts1o1LxRIq6UVcsQ==", C_js9);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0064 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 867
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [64] <- Index 64
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [65] <- WEB ADMIN Index 65 ---
		String requestProt0065 = "https";
		String requestHost0065 = "teck-test.wfsaas.ca";
		int    requestPort0065 = 443;
		String requestFile0065 = "/workforce/bundles/extJsCss/css/extjs/images/default/panel/top-bottom.gif";
		String requestHeader0065 = "GET " + requestFile0065 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0065, requestHost0065, requestPort0065, requestHeader0065, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("UYrXPxvMEZahQpGllOBlsw==", C_Css1);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0065 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 875
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [65] <- Index 65
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [66] <- WEB ADMIN Index 66 ---
		String requestProt0066 = "https";
		String requestHost0066 = "teck-test.wfsaas.ca";
		int    requestPort0066 = 443;
		String requestFile0066 = "/workforce/bundles/extJsCss/css/extjs/images/default/form/text-bg.gif";
		String requestHeader0066 = "GET " + requestFile0066 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0066, requestHost0066, requestPort0066, requestHeader0066, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("UYrXPxvMEZahQpGllOBlsw==", C_Css1);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0066 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 819
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [66] <- Index 66
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [67] <- WEB ADMIN Index 67 ---
		String requestProt0067 = "https";
		String requestHost0067 = "teck-test.wfsaas.ca";
		int    requestPort0067 = 443;
		String requestFile0067 = "/workforce/UserPreferences.do" +
				"?action=set";
		String requestContent0067 = 
				"trxn=%7B%22ReportNavigationPanel.RecentlyViewed%22%3A%5B%22STD_ASGNMT_GRP_DETAIL%22%2C%22STD_SWIPES%22%2C%22STD_SWIPE_ERROR%22%5D%7D" +
				"&loaderTimestamp=1573601806458" +
				"&transactionID=3" +
				"&HttpJsonResponse=true" +
				"&csrfToken=" + C_CsrfToken1;		// recorded value = 1A1573601613498A923882780
		requestContent0067 = Lib.replaceTextPattern(requestContent0067, "1A1573601613498A923882780", C_CsrfToken1, 0);		// search and replace content fragment "1A1573601613498A923882780" with variable 'C_CsrfToken1' on all occurrences

		byte[] requestContentBinary0067 = requestContent0067.getBytes("UTF-8");
		String requestHeader0067 = "POST " + requestFile0067 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0067.length + "\r\n" + 		// Content-Length: 237
				"Origin: https://teck-test.wfsaas.ca\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0067, requestHost0067, requestPort0067, requestHeader0067, requestContentBinary0067, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0067 = null;		// support garbage collector to reduce memory
		requestContent0067 = null;		// support garbage collector to reduce memory
		requestContentBinary0067 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 149
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "{\"success\": true,\"preferences\": {");		// Test [67] <- Index 67
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #4 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #5.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_5(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #5: Run Report
		// # -------------------



		// --- HTTP REQUEST: Test [69] <- WEB ADMIN Index 69 ---
		String requestProt0069 = "https";
		String requestHost0069 = "teck-test.wfsaas.ca";
		int    requestPort0069 = 443;
		String requestFile0069 = "/workforce/bundles/extJsCss/css/extjs/images/default/shadow.png";
		String requestHeader0069 = "GET " + requestFile0069 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0069, requestHost0069, requestPort0069, requestHeader0069, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("UYrXPxvMEZahQpGllOBlsw==", C_Css1);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0069 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 311
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [69] <- Index 69
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [70] <- WEB ADMIN Index 70 ---
		String requestProt0070 = "https";
		String requestHost0070 = "teck-test.wfsaas.ca";
		int    requestPort0070 = 443;
		String requestFile0070 = "/workforce/bundles/extJsCss/css/extjs/images/default/shadow-lr.png";
		String requestHeader0070 = "GET " + requestFile0070 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0070, requestHost0070, requestPort0070, requestHeader0070, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("UYrXPxvMEZahQpGllOBlsw==", C_Css1);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0070 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 135
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [70] <- Index 70
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [71] <- WEB ADMIN Index 71 ---
		String requestProt0071 = "https";
		String requestHost0071 = "teck-test.wfsaas.ca";
		int    requestPort0071 = 443;
		String requestFile0071 = "/workforce/bundles/extJsCss/css/extjs/images/default/shadow-c.png";
		String requestHeader0071 = "GET " + requestFile0071 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0071, requestHost0071, requestPort0071, requestHeader0071, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("UYrXPxvMEZahQpGllOBlsw==", C_Css1);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0071 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 118
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [71] <- Index 71
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [72] <- WEB ADMIN Index 72 ---
		log();
		log("# title: Crystal&#x20;Reports&#x20;Viewer");
		String requestProt0072 = "https";
		String requestHost0072 = "teck-test.wfsaas.ca";
		int    requestPort0072 = 443;
		String requestFile0072 = "/workforce/Reports.do" +
				"?action=getReportPolicyOutputInWindow";
		String requestContent0072 = 
				"trxn=%7B%22reportPolicyId%22%3A%22STD_ASGNMT_GRP_DETAIL%22%2C%22parameterValues%22%3A%7B%22STD_ASSIGNMENT_GROUP_LIST%22%3A%22%5B%5C%222013193140%5C%22%2C%5C%222013194129%5C%22%5D%22%2C%22STD_LANGUAGE%22%3A%22%5C%22ENGLISH_US%5C%22%22%7D%2C%22reportDeliveryOptions%22%3A%7B%22deliveryMethod%22%3A%22REPORT_DELIVERY_METHOD.NEW_WINDOW%22%2C%22deliveryFormat%22%3A%22REPORT_FORMAT.HTML%22%2C%22localeId%22%3A%22%22%2C%22emailAddresses%22%3A%5B%5D%2C%22emailSubject%22%3A%22%22%2C%22emailBody%22%3A%22%22%7D%2C%22reportScheduleId%22%3Anull%7D" +
				"&loaderTimestamp=1573601820832" +
				"&csrfToken=" + C_CsrfToken1;		// recorded value = 1A1573601613498A923882780
		requestContent0072 = Lib.replaceTextPattern(requestContent0072, "1A1573601613498A923882780", C_CsrfToken1, 0);		// search and replace content fragment "1A1573601613498A923882780" with variable 'C_CsrfToken1' on all occurrences

		String requestHeader0072 = "POST " + requestFile0072 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0072.length() + "\r\n" + 		// Content-Length: 603
				"Origin: https://teck-test.wfsaas.ca\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0072, requestHost0072, requestPort0072, requestHeader0072, requestContent0072.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0072 = null;		// support garbage collector to reduce memory
		requestContent0072 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 7282
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Created&nbsp;by");		// Test [72] <- Index 72
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getContentString());

		// setup var extractor for 'C_dynamicImage'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0072_1 = new BoundaryBasedExtractorItem( "dynamicimage=" , ".png",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0072_1);

		// setup var extractor for 'C_loggingID'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0072_2 = new BoundaryBasedExtractorItem( "logging\":{\"id\":" , ",\"enabled\":true}",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0072_2);

		boundaryBasedExtractor.extractText();
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getHeaderString());

		boundaryBasedExtractor.extractText();
		try
		{
			// extract var 'C_dynamicImage'
			C_dynamicImage = boundaryBasedContentExtractorItem0072_1.getResultText();
			log("<<< C_dynamicImage = " + C_dynamicImage);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_dynamicImage!= null && C_dynamicImage.trim().length() == 0)
			{
				C_dynamicImage = "";
				log("runtime note: the extraction of a new value for the variable 'C_dynamicImage' ends up with an empty string - a substitute value was set");
				log("<<< C_dynamicImage = " + C_dynamicImage);
			}
		}
		catch (Exception e) { C_dynamicImage = null; log(e); }
		if (C_dynamicImage == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_dynamicImage' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'C_loggingID'
			C_loggingID = boundaryBasedContentExtractorItem0072_2.getResultText();
			log("<<< C_loggingID = " + C_loggingID);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_loggingID!= null && C_loggingID.trim().length() == 0)
			{
				C_loggingID = "";
				log("runtime note: the extraction of a new value for the variable 'C_loggingID' ends up with an empty string - a substitute value was set");
				log("<<< C_loggingID = " + C_loggingID);
			}
		}
		catch (Exception e) { C_loggingID = null; log(e); }
		if (C_loggingID == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_loggingID' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [73] <- WEB ADMIN Index 73 ---
		String requestProt0073 = "https";
		String requestHost0073 = "teck-test.wfsaas.ca";
		int    requestPort0073 = 443;
		String requestFile0073 = "/workforce/UserPreferences.do" +
				"?action=set";
		String requestContent0073 = 
				"trxn=%7B%22Reports.ReportDeliveryOptions%22%3A%22%7B%5C%22STD_SWIPES%5C%22%3A%7B%5C%22deliveryMethod%5C%22%3A%5C%22REPORT_DELIVERY_METHOD.NEW_WINDOW%5C%22%2C%5C%22deliveryFormat%5C%22%3A%5C%22REPORT_FORMAT.HTML%5C%22%2C%5C%22localeId%5C%22%3A%5C%22%5C%22%2C%5C%22emailAddresses%5C%22%3A%5B%5D%2C%5C%22emailSubject%5C%22%3A%5C%22%5C%22%2C%5C%22emailBody%5C%22%3A%5C%22%5C%22%7D%2C%5C%22STD_ASGNMT_GRP_DETAIL%5C%22%3A%7B%5C%22deliveryMethod%5C%22%3A%5C%22REPORT_DELIVERY_METHOD.NEW_WINDOW%5C%22%2C%5C%22deliveryFormat%5C%22%3A%5C%22REPORT_FORMAT.HTML%5C%22%2C%5C%22localeId%5C%22%3A%5C%22%5C%22%2C%5C%22emailAddresses%5C%22%3A%5B%5D%2C%5C%22emailSubject%5C%22%3A%5C%22%5C%22%2C%5C%22emailBody%5C%22%3A%5C%22%5C%22%7D%7D%22%7D" +
				"&loaderTimestamp=1573601825797" +
				"&transactionID=4" +
				"&HttpJsonResponse=true" +
				"&csrfToken=" + C_CsrfToken1;		// recorded value = 1A1573601613498A923882780
		requestContent0073 = Lib.replaceTextPattern(requestContent0073, "1A1573601613498A923882780", C_CsrfToken1, 0);		// search and replace content fragment "1A1573601613498A923882780" with variable 'C_CsrfToken1' on all occurrences

		byte[] requestContentBinary0073 = requestContent0073.getBytes("UTF-8");
		String requestHeader0073 = "POST " + requestFile0073 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0073.length + "\r\n" + 		// Content-Length: 828
				"Origin: https://teck-test.wfsaas.ca\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0073, requestHost0073, requestPort0073, requestHeader0073, requestContentBinary0073, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0073 = null;		// support garbage collector to reduce memory
		requestContent0073 = null;		// support garbage collector to reduce memory
		requestContentBinary0073 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 494
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "{\"success\": true,\"preferences\"");		// Test [73] <- Index 73
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [74] <- WEB ADMIN Index 74 ---
		String requestProt0074 = "https";
		String requestHost0074 = "teck-test.wfsaas.ca";
		int    requestPort0074 = 443;
		String requestFile0074 = "/workforce/crystalreportviewers/js/crviewer/crv.js";
		String requestHeader0074 = "GET " + requestFile0074 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0074, requestHost0074, requestPort0074, requestHeader0074, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0074 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 24263
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [74] <- Index 74
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [75] <- WEB ADMIN Index 75 ---
		String requestProt0075 = "https";
		String requestHost0075 = "teck-test.wfsaas.ca";
		int    requestPort0075 = 443;
		String requestFile0075 = "/workforce/crystalreportviewers/js/crviewer/images/style.css";
		String requestHeader0075 = "GET " + requestFile0075 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0075, requestHost0075, requestPort0075, requestHeader0075, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0075 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 3416
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [75] <- Index 75
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [76] <- WEB ADMIN Index 76 ---
		String requestProt0076 = "https";
		String requestHost0076 = "teck-test.wfsaas.ca";
		int    requestPort0076 = 443;
		String requestFile0076 = "/workforce/crystalreportviewers/js/dhtmllib/images/skin_standard/wait01.gif";
		String requestHeader0076 = "GET " + requestFile0076 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0076, requestHost0076, requestPort0076, requestHeader0076, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0076 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 2488
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [76] <- Index 76
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [77] <- WEB ADMIN Index 77 ---
		String requestProt0077 = "https";
		String requestHost0077 = "teck-test.wfsaas.ca";
		int    requestPort0077 = 443;
		String requestFile0077 = "/workforce/crystalreportviewers/js/dhtmllib/images/skin_standard/dialogtitle.gif";
		String requestHeader0077 = "GET " + requestFile0077 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0077, requestHost0077, requestPort0077, requestHeader0077, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0077 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 2512
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [77] <- Index 77
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [78] <- WEB ADMIN Index 78 ---
		String requestProt0078 = "https";
		String requestHost0078 = "teck-test.wfsaas.ca";
		int    requestPort0078 = 443;
		String requestFile0078 = "/workforce/crystalreportviewers/js/dhtmllib/images/skin_standard/dialogelements.gif";
		String requestHeader0078 = "GET " + requestFile0078 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0078, requestHost0078, requestPort0078, requestHeader0078, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0078 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 171
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [78] <- Index 78
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [79] <- WEB ADMIN Index 79 ---
		String requestProt0079 = "https";
		String requestHost0079 = "teck-test.wfsaas.ca";
		int    requestPort0079 = 443;
		String requestFile0079 = "/workforce/crystalreportviewers/allStrings_en.js";
		String requestHeader0079 = "GET " + requestFile0079 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0079, requestHost0079, requestPort0079, requestHeader0079, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0079 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 16242
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [79] <- Index 79
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [80] <- WEB ADMIN Index 80 ---
		String requestProt0080 = "https";
		String requestHost0080 = "teck-test.wfsaas.ca";
		int    requestPort0080 = 443;
		String requestFile0080 = "/workforce/crystalreportviewers/js/log4javascript/log4javascript.js";
		String requestHeader0080 = "GET " + requestFile0080 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0080, requestHost0080, requestPort0080, requestHeader0080, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0080 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 128953
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [80] <- Index 80
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [81] <- WEB ADMIN Index 81 ---
		String requestProt0081 = "https";
		String requestHost0081 = "teck-test.wfsaas.ca";
		int    requestPort0081 = 443;
		String requestFile0081 = "/workforce/crystalreportviewers/js/dhtmllib/images/transp.gif";
		String requestHeader0081 = "GET " + requestFile0081 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0081, requestHost0081, requestPort0081, requestHeader0081, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0081 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 85
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [81] <- Index 81
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [82] <- WEB ADMIN Index 82 ---
		String requestProt0082 = "https";
		String requestHost0082 = "teck-test.wfsaas.ca";
		int    requestPort0082 = 443;
		String requestFile0082 = "/workforce/crystalreportviewers/allInOne.js";
		String requestHeader0082 = "GET " + requestFile0082 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0082, requestHost0082, requestPort0082, requestHeader0082, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0082 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 670898
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [82] <- Index 82
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [83] <- WEB ADMIN Index 83 ---
		String requestProt0083 = "https";
		String requestHost0083 = "teck-test.wfsaas.ca";
		int    requestPort0083 = 443;
		String requestFile0083 = "/workforce/crystalreportviewers/promptengine-compressed.js";
		String requestHeader0083 = "GET " + requestFile0083 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0083, requestHost0083, requestPort0083, requestHeader0083, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0083 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 55890
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [83] <- Index 83
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [84] <- WEB ADMIN Index 84 ---
		String requestProt0084 = "https";
		String requestHost0084 = "teck-test.wfsaas.ca";
		int    requestPort0084 = 443;
		String requestFile0084 = "/workforce/crystalreportviewers/js/dhtmllib/images/skin_standard/style.css";
		String requestHeader0084 = "GET " + requestFile0084 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0084, requestHost0084, requestPort0084, requestHeader0084, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0084 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2943
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [84] <- Index 84
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [85] <- WEB ADMIN Index 85 ---
		String requestProt0085 = "https";
		String requestHost0085 = "teck-test.wfsaas.ca";
		int    requestPort0085 = 443;
		String requestFile0085 = "/workforce/CrystalReportViewerHandler" +
				"?ServletTask=Log";
		String requestContent0085 = 
				"logger=%5Banonymous%5D" +
				"&timestamp=1573601826562" +
				"&level=INFO" +
				"&url=https%3A%2F%2Fteck-test.wfsaas.ca%2Fworkforce%2FReports.do%3Faction%3DgetReportPolicyOutputInWindow" +
				"&message=287739598%20Logging%20Initialized" +
				"&layout=HttpPostDataLayout";
		requestContent0085 = Lib.replaceTextPattern(requestContent0085, "287739598", C_loggingID, 0);		// search and replace content fragment "287739598" with variable 'C_loggingID' on all occurrences

		String requestHeader0085 = "POST " + requestFile0085 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0085.length() + "\r\n" + 		// Content-Length: 229
				"Origin: https://teck-test.wfsaas.ca\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0085, requestHost0085, requestPort0085, requestHeader0085, requestContent0085.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0085 = null;		// support garbage collector to reduce memory
		requestContent0085 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, null, null, null);		// Test [85] <- Index 85
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [86] <- WEB ADMIN Index 86 ---
		String requestProt0086 = "https";
		String requestHost0086 = "teck-test.wfsaas.ca";
		int    requestPort0086 = 443;
		String requestFile0086 = "/workforce/crystalreportviewers/js/dhtmllib/images/resizepattern.gif";
		String requestHeader0086 = "GET " + requestFile0086 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0086, requestHost0086, requestPort0086, requestHeader0086, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0086 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 815
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [86] <- Index 86
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [87] <- WEB ADMIN Index 87 ---
		String requestProt0087 = "https";
		String requestHost0087 = "teck-test.wfsaas.ca";
		int    requestPort0087 = 443;
		String requestFile0087 = "/workforce/crystalreportviewers/js/dhtmllib/empty.html";
		String requestHeader0087 = "GET " + requestFile0087 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0087, requestHost0087, requestPort0087, requestHeader0087, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0087 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 275
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [87] <- Index 87
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [88] <- WEB ADMIN Index 88 ---
		String requestProt0088 = "https";
		String requestHost0088 = "teck-test.wfsaas.ca";
		int    requestPort0088 = 443;
		String requestFile0088 = "/workforce/crystalreportviewers/js/crviewer/images/min.gif";
		String requestHeader0088 = "GET " + requestFile0088 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0088, requestHost0088, requestPort0088, requestHeader0088, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0088 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 896
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [88] <- Index 88
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #5 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #5_1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_5_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #5 (fragment 2 of 2)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [89] <- WEB ADMIN Index 89 ---
		String requestProt0089 = "https";
		String requestHost0089 = "teck-test.wfsaas.ca";
		int    requestPort0089 = 443;
		String requestFile0089 = "/workforce/crystalreportviewers/js/crviewer/images/allInOne.gif";
		String requestHeader0089 = "GET " + requestFile0089 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0089, requestHost0089, requestPort0089, requestHeader0089, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0089 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 5851
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [89] <- Index 89
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [90] <- WEB ADMIN Index 90 ---
		String requestProt0090 = "https";
		String requestHost0090 = "teck-test.wfsaas.ca";
		int    requestPort0090 = 443;
		String requestFile0090 = "/workforce/crystalreportviewers/js/dhtmllib/images/skin_standard/menus.gif";
		String requestHeader0090 = "GET " + requestFile0090 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0090, requestHost0090, requestPort0090, requestHeader0090, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0090 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 1190
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [90] <- Index 90
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [91] <- WEB ADMIN Index 91 ---
		String requestProt0091 = "https";
		String requestHost0091 = "teck-test.wfsaas.ca";
		int    requestPort0091 = 443;
		String requestFile0091 = "/workforce/crystalreportviewers/js/dhtmllib/images/skin_standard/horiz_tabs.gif";
		String requestHeader0091 = "GET " + requestFile0091 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0091, requestHost0091, requestPort0091, requestHeader0091, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0091 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 4839
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [91] <- Index 91
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [92] <- WEB ADMIN Index 92 ---
		String requestProt0092 = "https";
		String requestHost0092 = "teck-test.wfsaas.ca";
		int    requestPort0092 = 443;
		String requestFile0092 = "/workforce/CrystalReportViewerHandler" +
				"?dynamicimage=crystal15736018257799146272510124031900.png";
		requestFile0092 = Lib.replaceTextPattern(requestFile0092, "crystal15736018257799146272510124031900", C_dynamicImage, 0);		// search and replace request file fragment "crystal15736018257799146272510124031900" with variable 'C_dynamicImage' on all occurrences

		String requestHeader0092 = "GET " + requestFile0092 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0092, requestHost0092, requestPort0092, requestHeader0092, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0092 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 26939
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [92] <- Index 92
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [93] <- WEB ADMIN Index 93 ---
		String requestProt0093 = "https";
		String requestHost0093 = "teck-test.wfsaas.ca";
		int    requestPort0093 = 443;
		String requestFile0093 = "/workforce/crystalreportviewers/js/crviewer/images/drill_cursor.cur";
		String requestHeader0093 = "GET " + requestFile0093 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0093, requestHost0093, requestPort0093, requestHeader0093, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0093 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 3262
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, null, null, null);		// Test [93] <- Index 93
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [94] <- WEB ADMIN Index 94 ---
		log();
		log("# title: 302 Found");
		String requestProt0094 = "https";
		String requestHost0094 = "teck-test.wfsaas.ca";
		int    requestPort0094 = 443;
		String requestFile0094 = "/favicon.ico";
		String requestHeader0094 = "GET " + requestFile0094 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0094, requestHost0094, requestPort0094, requestHeader0094, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0094 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = [verification disabled], content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 138
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, null, null, null, null);		// Test [94] <- Index 94
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [95] <- WEB ADMIN Index 95 ---
		String requestProt0095 = "https";
		String requestHost0095 = "teck-test.wfsaas.ca";
		int    requestPort0095 = 443;
		String requestFile0095 = "/workforce/Logon.do";
		String requestHeader0095 = "GET " + requestFile0095 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0095, requestHost0095, requestPort0095, requestHeader0095, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0095 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [95] <- Index 95
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [96] <- WEB ADMIN Index 96 ---
		log();
		log("# title: WorkForce Time");
		String requestProt0096 = "https";
		String requestHost0096 = "teck-test.wfsaas.ca";
		int    requestPort0096 = 443;
		String requestFile0096 = "/workforce/Desktop.do";
		String requestHeader0096 = "GET " + requestFile0096 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0096, requestHost0096, requestPort0096, requestHeader0096, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0096 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 7223
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "WorkForce Time");		// Test [96] <- Index 96
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #5_1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #6.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_6(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #6: LogOut
		// # ---------------



		// --- HTTP REQUEST: Test [98] <- WEB ADMIN Index 98 ---
		log();
		log("# title: WorkForce Time");
		String requestProt0098 = "https";
		String requestHost0098 = "teck-test.wfsaas.ca";
		int    requestPort0098 = 443;
		String requestFile0098 = "/workforce/Logoff.do";
		String requestHeader0098 = "GET " + requestFile0098 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0098, requestHost0098, requestPort0098, requestHeader0098, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("34AF004739AD45F59FF5D2283B74EAD0", C_JsessionID2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0098 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 4333
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "WorkForce Time");		// Test [98] <- Index 98
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getContentString());

		// setup var extractor for 'C_Css6'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0098_1 = new BoundaryBasedExtractorItem( "logoffCss_" , ".css",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0098_1);

		boundaryBasedExtractor.extractText();
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getHeaderString());

		boundaryBasedExtractor.extractText();
		try
		{
			// extract var 'C_Css6'
			C_Css6 = boundaryBasedContentExtractorItem0098_1.getResultText();
			log("<<< C_Css6 = " + C_Css6);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_Css6!= null && C_Css6.trim().length() == 0)
			{
				C_Css6 = "";
				log("runtime note: the extraction of a new value for the variable 'C_Css6' ends up with an empty string - a substitute value was set");
				log("<<< C_Css6 = " + C_Css6);
			}
		}
		catch (Exception e) { C_Css6 = null; log(e); }
		if (C_Css6 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_Css6' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [99] <- WEB ADMIN Index 99 ---
		String requestProt0099 = "https";
		String requestHost0099 = "teck-test.wfsaas.ca";
		int    requestPort0099 = 443;
		String requestFile0099 = "/workforce/bundles/logoffCss/logoffCss_navjbH4WDLOBS2wI_NiNyg==.css?";
		requestFile0099 = Lib.replaceTextPattern(requestFile0099, "navjbH4WDLOBS2wI_NiNyg==", C_Css6, 0);		// search and replace request file fragment "navjbH4WDLOBS2wI_NiNyg==" with variable 'C_Css6' on all occurrences

		String requestHeader0099 = "GET " + requestFile0099 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0099, requestHost0099, requestPort0099, requestHeader0099, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0099 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 458
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [99] <- Index 99
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [100] <- WEB ADMIN Index 100 ---
		String requestProt0100 = "https";
		String requestHost0100 = "teck-test.wfsaas.ca";
		int    requestPort0100 = 443;
		String requestFile0100 = "/workforce/bundles/logoffJs/logoffJs_zV1TBt7oAxZ8C-aR0gcNzg==.js?";
		String requestHeader0100 = "GET " + requestFile0100 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0100, requestHost0100, requestPort0100, requestHeader0100, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0100 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5151
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [100] <- Index 100
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [101] <- WEB ADMIN Index 101 ---
		String requestProt0101 = "https";
		String requestHost0101 = "teck-test.wfsaas.ca";
		int    requestPort0101 = 443;
		String requestFile0101 = "/workforce/images/big_warning.png" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0101 = Lib.replaceTextPattern(requestFile0101, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0101 = "GET " + requestFile0101 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0101, requestHost0101, requestPort0101, requestHeader0101, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.replaceRequestHeaderFieldTextPattern("navjbH4WDLOBS2wI_NiNyg==", C_Css6);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0101 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 3093
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [101] <- Index 101
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [102] <- WEB ADMIN Index 102 ---
		String requestProt0102 = "https";
		String requestHost0102 = "teck-test.wfsaas.ca";
		int    requestPort0102 = 443;
		String requestFile0102 = "/workforce/ServerTest.do";
		String requestContent0102 = 
				"loaderTimestamp=1573601845840" +
				"&transactionID=1" +
				"&HttpJsonResponse=true" +
				"&csrfToken=";
		byte[] requestContentBinary0102 = requestContent0102.getBytes("UTF-8");
		String requestHeader0102 = "POST " + requestFile0102 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0102.length + "\r\n" + 		// Content-Length: 79
				"Origin: https://teck-test.wfsaas.ca\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0102, requestHost0102, requestPort0102, requestHeader0102, requestContentBinary0102, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0102 = null;		// support garbage collector to reduce memory
		requestContent0102 = null;		// support garbage collector to reduce memory
		requestContentBinary0102 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 39
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "{\"isSuccessful\":true}");		// Test [102] <- Index 102
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [103] <- WEB ADMIN Index 103 ---
		log();
		log("# title: WorkForce Time");
		String requestProt0103 = "https";
		String requestHost0103 = "teck-test.wfsaas.ca";
		int    requestPort0103 = 443;
		String requestFile0103 = "/workforce/Desktop.do";
		String requestHeader0103 = "GET " + requestFile0103 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0103, requestHost0103, requestPort0103, requestHeader0103, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0103 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 6644
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Password\"");		// Test [103] <- Index 103
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [104] <- WEB ADMIN Index 104 ---
		String requestProt0104 = "https";
		String requestHost0104 = "teck-test.wfsaas.ca";
		int    requestPort0104 = 443;
		String requestFile0104 = "/workforce/bundles/bannerComponentsJs/bannerComponentsJs_LrGfo28H9cI42m61vkfacA==.js?";
		requestFile0104 = Lib.replaceTextPattern(requestFile0104, "LrGfo28H9cI42m61vkfacA==", C_js4, 0);		// search and replace request file fragment "LrGfo28H9cI42m61vkfacA==" with variable 'C_js4' on all occurrences

		String requestHeader0104 = "GET " + requestFile0104 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0104, requestHost0104, requestPort0104, requestHeader0104, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0104 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 32267
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [104] <- Index 104
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [105] <- WEB ADMIN Index 105 ---
		String requestProt0105 = "https";
		String requestHost0105 = "teck-test.wfsaas.ca";
		int    requestPort0105 = 443;
		String requestFile0105 = "/workforce/JSLib/wfs/LogonLocaleSwitcher.js" +
				"?ver=" + C_JSVersion;		// recorded value = 1030101427
		requestFile0105 = Lib.replaceTextPattern(requestFile0105, "1030101427", C_JSVersion, 0);		// search and replace request file fragment "1030101427" with variable 'C_JSVersion' on all occurrences

		String requestHeader0105 = "GET " + requestFile0105 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0105, requestHost0105, requestPort0105, requestHeader0105, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0105 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4202
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [105] <- Index 105
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [106] <- WEB ADMIN Index 106 ---
		String requestProt0106 = "https";
		String requestHost0106 = "teck-test.wfsaas.ca";
		int    requestPort0106 = 443;
		String requestFile0106 = "/workforce/bundles/statusListJs/statusListJs_4-0BZT30bHbEJc2jH21nxA==.js?";
		requestFile0106 = Lib.replaceTextPattern(requestFile0106, "4-0BZT30bHbEJc2jH21nxA==", C_Js3, 0);		// search and replace request file fragment "4-0BZT30bHbEJc2jH21nxA==" with variable 'C_Js3' on all occurrences

		String requestHeader0106 = "GET " + requestFile0106 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: teck-test.wfsaas.ca\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0106, requestHost0106, requestPort0106, requestHeader0106, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("31d778dc217542f078a1ab3c8a2c9074", C_SrvID);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "tzoffsetCookie"
		inlineScriptContext = executeInlineScript_1573614890836(testURL, threadStep, totalLoopCounter, innerLoopContext);
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0106 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1040
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [106] <- Index 106
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #6 successful done
		return true;
	}



	boolean synchResponsesParallelRequestsPage_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 1 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_1(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_1 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 2 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_2(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_2 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 3 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_3(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_3 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 4 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_4(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_4 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_5(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 5 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_5(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_5 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_6(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 6 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_6(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_6 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	/**
	 * implement GetRealTimeUserInputFieldsInterface: get the definition and the value of all real-time user input fields.
	 */
	public ArrayList<RealTimeUserInputField> getRealTimeUserInputFields()
	{
		try
		{
			ArrayList<RealTimeUserInputField> realTimeUserInputFieldList = new ArrayList<RealTimeUserInputField>();
			return realTimeUserInputFieldList;
		}
		catch (Exception e)
		{
			log(e);
			return null;
		}
	}



	/**
	 * implement ThreadStepInterface: get the current execution step (current URL call or page break) of a simulated user.
	 */
	public int getExecutionStep()
	{
		return threadStep;
	}



	/**
	 * implement SetThreadStepInterface: set the current execution step (current URL call or page break) of a simulated user.
	 */
	public void setExecutionStep(int threadStep)
	{
		this.threadStep = threadStep;
	}



	/**
	 * implement SSLSessionCacheStatisticInterface: get statistic data about the SSL session cache behavior of a simulated user.
	 */
	public SSLSessionCacheStatistic getSSLSessionCacheStatistic()
	{
		return sslStatistic;
	}



	/**
	 * implement VaryingTestDurationInterface: support to extend or to reduce the planned test duration.
	 */
	public int getPlannedTestDuration()
	{
		return plannedTestDuration;
	}
	
	public void setExtendTestDuration(int deltaSeconds)
	{
		if (plannedTestDuration == 0)
		{
			plannedTestDuration = deltaSeconds;		// the old planned test duration was unlimited but is now limited
			return;
		}
		if (deltaSeconds == 0)
		{
			plannedTestDuration = 0;		// the new planned test duration is now unlimited
			return;
		}
		plannedTestDuration = plannedTestDuration + deltaSeconds;
	}



	/**
	 * implement SuspendResumeInterface: support to suspend and to resume the test execution.
	 */
	public int getPlannedStartupDelay()
	{
		return plannedStartupDelay;
	}
	
	public void setUserResumeStartWaitDelay(int millis)
	{
		userResumeStartWaitDelay = millis;
	}



	/**
	 * implement VaryingLoadInterface: support to decrement the number of simulated users at runtime.
	 */
	public void setDecrementEndOfLoopFlag(boolean decrementEndOfLoopFlag)
	{
		this.decrementEndOfLoopFlag = decrementEndOfLoopFlag;
	}

	public boolean isDecrementEndOfLoopFlag()
	{
		return decrementEndOfLoopFlag;
	}



	/**
	 * internal method: execute the loops for one simulated user as a thread.
	 * controls the thread and displays the (thread-)log if one loop has been completed.
	 */
	public void run()
	{
		// user terminated by inline script, at start of user ?
		if (isTerminateUser())
		{
			System.out.println("# --- thread " + Thread.currentThread().getName() + " aborted --- " + ZoneTime.dateToShortString() + " ---");
			return;
		}
		try
		{
			while (true)
			{
				threadStep = ThreadStepInterface.THREAD_NO_STEP;
				clearLog();
				
				// execute loop
				log("--- loop started --- " + ZoneTime.dateToShortString() + " ---");
				boolean loopPassed = this.execute(totalLoopCounter.getAndIncrement());
				performanceData.addUserTransactionMeasuredSamples(transactionHandler.getPendingTransactions());
				ArrayList<UserTransactionContext> nonExecutedTransactions = transactionHandler.getNotExecutedTransactions();

				for (UserTransactionContext nonExecutedTransaction : new ArrayList<>(nonExecutedTransactions))
				{
					if(transactionContextMap.containsKey(nonExecutedTransaction.getTransactionId()+"") && transactionContextMap.get(nonExecutedTransaction.getTransactionId()+"") == null)
					{
						transactionContextMap.remove(nonExecutedTransaction.getTransactionId()+"");
						nonExecutedTransactions.remove(nonExecutedTransaction);
					}
				}

				performanceData.addUserTransactionNotExecutedSamples(nonExecutedTransactions);
				performanceData.addSocktPoolStatistic(socketPool);
				socketPool.closePool();
				performanceData.addSSLCacheStatistic(sslStatistic.getSSLSessionCacheStatisticResult());
				sslStatistic.reset();
				
				// eof of input file ?
				if (abortedByEofInputFile())
					return;		// endOfRun() not called in such a case
				
				// check loop result
				String remainingLoopInfo = "";
				if (checkLoopCount)
					remainingLoopInfo = " [remaining loops = " + (remainingLoops - 1) + "]";
				if (loopPassed)
				{
					performanceData.addPassedLoop();
					log("--- loop passed ---  " + ZoneTime.dateToShortString() + " ---" + remainingLoopInfo);
				}
				else
				{
					performanceData.addFailedLoop();
					log("--- loop failed ---  " + ZoneTime.dateToShortString() + " ---" + remainingLoopInfo);
				}
				threadStep = ThreadStepInterface.THREAD_NO_STEP;
				
				// display thread log to standard output
				if (debugLoops || (debugFailedLoops && (!loopPassed)))
				{
					synchronized (dumpLock)
					{
						dumpLog(System.out);				// full log
					}
				}
				
				// check if max loops reached
				if (checkLoopCount)
				{
					// all done ?
					remainingLoops--;
					if (remainingLoops <= 0)
					{
						endOfRun();
						return;
					}
				}
				
				// check if simulated user must be decremented
				if (decrementEndOfLoopFlag && (getOwnLoadTestUserContext().getDecrementEndOfLoopPointInTime() <= System.currentTimeMillis()))
				{
					return;
				}
				
				// check if max test duration reached
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				{
					endOfRun();
					return;
				}
				
				// check if this specific user is terminated earlier than planned by a HTTP content verification or by a plug-in
				if (isTerminateUser())
				{
					endOfRun();
					System.out.println("# --- thread " + Thread.currentThread().getName() + " terminate failed user --- " + ZoneTime.dateToShortString() + " ---");
					return;
				}
				
				// check if load test execution is temporary suspended
				boolean wasSuspended = false;
				while (isSuspend())
				{
					wasSuspended = true;
					try { Thread.currentThread().sleep(20); } catch (InterruptedException ie) {}
					if (abortedByRemote() || abortedByEofInputFile())
					{
						endOfRun();
						return;
					}
					
					// check if max test duration reached during suspend
					if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
					{
						endOfRun();
						return;
					}
				}
				// check if load test execution is resumed
				if (wasSuspended)
				{
					try { sleepRemoteInterruptable(userResumeStartWaitDelay); } catch (InterruptedException ie) {}
				}
				
				// wait 20 milliseconds if loop has failed
				if (!loopPassed)
					try { Thread.currentThread().sleep(loopErrorDelay); } catch (InterruptedException ie) {}
				
				// execute next loop
				threadLoopCounter++;
			}	// end: while (true)
		}
		catch (Throwable tex)
		{
			log("*** INTERNAL ERROR / LOAD TEST ABORTED ***");
			log(tex);
			log();
			synchronized (dumpLock)
			{
				dumpLog(System.out);				// full log
				System.err.println("*** INTERNAL ERROR / LOAD TEST ABORTED ***");
				tex.printStackTrace(System.err);
				System.exit(-2);
			}
		}
		finally
		{
			// remove the reference to this load test instance and the reference to the thread that runs this instance
			try
			{
				if (!decrementEndOfLoopFlag)
				{
					getUserContextTable().getWriteLock().lock();
					getOwnLoadTestUserContext().setLoadTestUserFinallyEnded();
					getUserContextTable().getWriteLock().unlock();
				}
				else
					decrementEndOfLoopFlag = false;
			}
			catch (Throwable texFinal)
			{
				System.err.println("*** INTERNAL FINALLY ERROR / LOAD TEST ABORTED ***");
				texFinal.printStackTrace(System.err);
				System.exit(-2);
			}
		}
	}



	/**
	 * internal method: called when a user has completed the test-run.
	 */
	public void endOfRun()
	{
		clearLog();
		
		if (debugLoops && (getLog().size() > 0))
		{
			synchronized (dumpLock)
			{
				dumpLog(System.out);		// dump log of inline scripts and load test plug-ins which are executed at end of user
			}
		}
	}



	/**
	 * Main program. Starts the test and waits until all have been done.
	 */
	public static void main(String[] args)
	{
		// check command line argument -h or -help
		if ((ParseArgs.hasOption(args, "-h")) || (ParseArgs.hasOption(args, "-help")))
		{
			System.out.println();
			System.out.println("Help - Proxy Sniffer Load Test Program:");
			System.out.println();
			System.out.println("-u <number>              ->> required argument: number of concurrent users");
			System.out.println("-d <seconds>             ->> required argument: planned test duration in seconds (default: 30, 0 = unlimited)");
			System.out.println("-t <seconds>             ->> required argument: request timeout per url in seconds");
			System.out.println();
			System.out.println("-tconnect <seconds>      ->> TCP/IP socket connect timeout in seconds (default: use value of -t <seconds>)");
			System.out.println();
			System.out.println("-sdelay <milliseconds>   ->> startup delay time between concurrent users in milliseconds (default: 200)");
			System.out.println("-mtpu <number>           ->> maximum number of parallel threads per user (default: " + MAX_PARALLEL_THREADS_PER_USER + ")");
			System.out.println("-maxloops <number>       ->> maximum number of loops per user (default: 0 = unlimited)");
			System.out.println("-downlink <kbps>         ->> maximum downlink network bandwidth per user in kilobits per second (default: 0 = unlimited)");
			System.out.println("-uplink <kbps>           ->> maximum uplink network bandwidth per user in kilobits per second (default: 0 = unlimited)");
			System.out.println("-multihomed <filename>   ->> use serveral client ip addresses - file format: <addr1>, <addr2>, ... (all on the same line)");
			System.out.println("-sampling <seconds>      ->> statistic sampling interval in seconds (default: 15)");
			System.out.println("-percpage <percent>      ->> additional sampling rate per web page call in percent (default: 100)");
			System.out.println("-percurl <percent>       ->> additional sampling rate per url call in percent (default: 0)");
			System.out.println("-percurlopt <level>      ->> extended sampling level per url call, see application reference manual (default: 0 = disabled)");
			System.out.println("-maxerrsnap <number>     ->> maximum number of error snapshots per url (default: 0 = unlimited)");
			System.out.println("-maxerrmem <megabytes>   ->> maximum size of memory in megabytes which can be used for error snapshots (default: 20, -1 = unlimited)");
			System.out.println("-nosdelayCluster         ->> apply startup delay time between concurrent users per exec agent, but not per cluster job (default: apply per cluster job)");
			System.out.println("-setuseragent \"<text>\"   ->> replace the recorded value of the HTTP request header field User-Agent with a new value");
			System.out.println("-collect <host>[:<port>] ->> collect additional data from external measuring agents (data collectors)");
			System.out.println("-res <filename>          ->> overrides the default name of the binary output file");
			System.out.println("-nores                   ->> disables to create the binary output file");
			System.out.println();
			System.out.println("-ssl <version>           ->> set SSL version: possible options are \"all\" (default), \"v3\", \"tls\", \"tls11\" or \"tls12\"");
			System.out.println("-sslcache <seconds>      ->> timeout of user-related SSL session cache (default: 300, 0 = cache disabled)");
			System.out.println("-sslrandom <type>        ->> set the type of the random generator used for SSL handshakes: possible options are \"fast\", \"iaik\" (default) or \"java\"");
			System.out.println("-sslcmode                ->> apply SSL/HTTPS compatibility workarounds for deficient SSL servers");
			System.out.println("-ecc                     ->> enable support of elliptic curve cryptography (ECC)");
			System.out.println("-nosni                   ->> disable support of server name indication (SNI)");
			System.out.println("-snicritical             ->> set the TLS SNI extension as critical (default: non-critical)");
			System.out.println("-tlssessiontickets       ->> set the TLS to use Session Tickets (non-critical)");
			System.out.println("-iaikLast                ->> adds the IAIK security provider at the last position (instead of default: IAIK at first position)");
			System.out.println();
			System.out.println("-dnssrv <IP-1>[,IP-N])   ->> use specific DNS server(s) to resolve DNS host names (default: use OS to resolve host names)");
			System.out.println("-dnshosts <filename>     ->> use specific DNS hosts file (default: use OS to resolve host names)");
			System.out.println("-dnstranslation <filename> ->> use a DNS translation file that converts DNS names. It might be needed to disable TLS SNI if this option is used");
			System.out.println("-dnsenattl               ->> enable consideration of DNS TTL by using the received TTL-values from the DNS Server(s) (default: TTL disabled)");
			System.out.println("-dnsfixttl <seconds>     ->> enable DNS TTL by using a fixed TTL-value of seconds for all DNS resolves");
			System.out.println("-dnsperloop              ->> perform new DNS resolves for each executed loop. All resolves are stable within the same loop (no consideration of DNS TTL within a loop)");
			System.out.println("-dnsstatistic            ->> collect statistical data about DNS resolutions. Note: use this option only if not any other, more specific DNS option is enabled");
			System.out.println("-dnsdebug                ->> debug DNS resolves and the DNS cache");
			System.out.println("-enableIPv6 <networkinterface-name>  ->> enable only IPv6 support for recording, also can provide the IPv6 network interface of the load generator");
			System.out.println("-enableIPv6v4 <networkinterface-name> ->> enable both IPv6 and IPv4 (first will try with IPv6 ,if fails will try with IPv4 support for recording),also can provide the IPv6 network interface of the load generator");
			System.out.println();
			System.out.println("-dfl                     ->> debug execution steps of all failed loops to standard output");
			System.out.println("-dl                      ->> debug execution steps of all loops to standard output");
			System.out.println("-dh                      ->> debug HTTP protocol headers to standard output, includes the -dl option");
			System.out.println("-dc                      ->> debug HTTP content data to standard output, includes the -dl option");
			System.out.println("-dhc                     ->> debug HTTP protocol headers and HTTP content data to standard output, includes the -dl option");
			System.out.println("-dC                      ->> debug cookies to standard output, includes the -dl option");
			System.out.println("-dK                      ->> debug keep-alive (socket pool) to standard output, includes the -dl option");
			System.out.println("-dssl                    ->> debug SSL handshake (https) to standard output, includes the -dl and the -dK option");
			System.out.println();
			System.out.println("-tz <timezone>           ->> set time zone (see Application Reference Manual: supported time zones)");
			System.out.println("-dgs a|c                 ->> set number format (decimal group separator) a = '  c = ,");
			System.out.println("-annotation <text>       ->> adds an annotation for this test run");
			System.out.println();
			System.out.println("-execAgentHost <ip address or dns name>      ->> set the ip address or the dns name of the exec agent from which the license is used (default: 127.0.0.1)");
			System.out.println("-execAgentPort <port>                        ->> set the tcp/ip port of the exec agent (default: 7993)");
			System.out.println("-execAgentProtocol <plain | http | https>    ->> set the protocol of the exec agent (default: plain)");
			System.out.println("-execAgentUsername <string>                  ->> set the auth. username for the exec agent (default: [no username])");
			System.out.println("-execAgentPassword <string>                  ->> set the auth. password for the exec agent (default: [no password])");
			System.out.println();
			System.out.println("-h                       ->> display this help text");
			System.out.println("-help                    ->> display this help text");
			System.out.println();
			System.exit(-1);
		}
		
		System.out.println("+----------------------------------------------------------------+");
		System.out.println("| Welcome to the ZebraTester Load Test Program.                  |");
		System.out.println("| Additional help available with program argument \"-help\"        |");
		System.out.println("| Procedure Copyright by Ingenieurbuero David Fischer AG,        |");
		System.out.println("| a company of the Apica group. All rights reserved.             |");
		System.out.println("+----------------------------------------------------------------+");
		
		
		if (commonNextProxyConfig != null)
		{
			System.out.println();
			System.out.println("*** Warning: Loadtest over HTTP(S) Proxy ***");
		}
		
		// check command line argument -ecc
		sslECC = (ParseArgs.hasOption(args, "-ecc"));       // enable ssl ecc ?
		
		// initialize ssl/https support
		SSLInit.execute(!ParseArgs.hasOption(args, "-iaikLast"), true);
		if (sslECC)
			SSLInit.enableECC();
		
		// check command line argument -nosni
		if (ParseArgs.hasOption(args, "-nosni"))            // disable ssl sni ?
			sslSNI = false;
		
		// check command line argument -snicritical
		if (ParseArgs.hasOption(args, "-snicritical"))      // set ssl sni as critical tls extension ?
			sslSNICirical = true;
		
		// check command line argument -tlssessiontickets
		if (ParseArgs.hasOption(args, "-tlssessiontickets"))      // set tls extension session tickets?
			useTlsSessionTickets = true;
		
		// set default character set for response content tests
		setCharEncoding(prxCharEncoding);
		
		// check command line argument -tz <timezone>
		String timeZoneString = ParseArgs.getString(args, "-tz");
		if (timeZoneString != null)
			defaultTimeZone = timeZoneString.toUpperCase(); // set time zone?
		ZoneTime.setDefaultTimeZone(defaultTimeZone);
		
		// check command line argument -dgs a|c
		String dgs = ParseArgs.getString(args, "-dgs");
		if (dgs != null)
		{
			if (dgs.equalsIgnoreCase("a"))
				defaultNumberGroupingSeparator = '\'';
			if (dgs.equalsIgnoreCase("c"))
				defaultNumberGroupingSeparator = ',';
		}
		Lib.setDefaultNumberGroupingSeparator(defaultNumberGroupingSeparator);
		
		// check command line argument -annotation <text>
		String testRunAnnotation = ParseArgs.getString(args, "-annotation");
		if (testRunAnnotation != null)
		{
			if (testRunAnnotation.startsWith("\"") && testRunAnnotation.endsWith("\""))
				testRunAnnotation = testRunAnnotation.substring(1, testRunAnnotation.length() - 1);
		}
		
		// check command line argument -ssl
		String newSslProtocolVersion = ParseArgs.getString(args, "-ssl");
		if (newSslProtocolVersion != null)
		{
			if (newSslProtocolVersion.equalsIgnoreCase("v2"))
				sslProtocolVersion = "v2";
			if (newSslProtocolVersion.equalsIgnoreCase("v3"))
				sslProtocolVersion = "v3";
			if (newSslProtocolVersion.equalsIgnoreCase("tls"))
				sslProtocolVersion = "tls";
			if (newSslProtocolVersion.equalsIgnoreCase("tls11"))
				sslProtocolVersion = "tls11";
			if (newSslProtocolVersion.equalsIgnoreCase("tls12"))
				sslProtocolVersion = "tls12";
		}
		
		// check command line argument -sslcache <seconds>
		Integer newSslSessionCacheTimeout = ParseArgs.getInteger(args, "-sslcache");
		if (newSslSessionCacheTimeout != null)
			sslSessionCacheTimeout = newSslSessionCacheTimeout.intValue();
		
		// check command line argument -sslrandom
		String sslHandshakeRandomGeneratorTypeStr = ParseArgs.getString(args, "-sslrandom");
		if (sslHandshakeRandomGeneratorTypeStr != null)
		{
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("java"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_JAVA_DEFAULT;
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("iaik"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_IAIK_DEFAULT;
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("fast"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_FAST;
		}
		
		// check command line argument -sslcmode
		sslcmode = ParseArgs.hasOption(args, "-sslcmode");  // enable ssl/https compatibility workarounds?
		
		// check command line argument -dfl
		debugFailedLoops = ParseArgs.hasOption(args, "-dfl"); // debug failed loops?
		
		// check command line argument -dl
		debugLoops = ParseArgs.hasOption(args, "-dl");      // debug loops?
		
		// check command line argument -dh
		debugHttp = ParseArgs.hasOption(args, "-dh");       // debug http?
		if (debugHttp)
			debugLoops = true;
		
		// check command line argument -dc
		debugContent = ParseArgs.hasOption(args, "-dc");    // debug content?
		if (debugContent)
			debugLoops = true;
		
		// check command line argument -dhc
		if (ParseArgs.hasOption(args, "-dhc"))				// debug http and content
		{
			debugLoops = true;
			debugHttp = true;
			debugContent = true;
		}
		
		// check command line argument -dC
		debugCookies = ParseArgs.hasOption(args, "-dC");    // debug cookies?
		if (debugCookies)
			debugLoops = true;
		
		// check command line argument -dK
		debugKeepAlive = ParseArgs.hasOption(args, "-dK");  // debug keep.alive (socket pool)?
		if (debugKeepAlive)
			debugLoops = true;
		
		// check command line argument -dssl
		debugSsl = ParseArgs.hasOption(args, "-dssl");      // debug keep.alive (socket pool)?
		if (debugSsl)
		{
			debugLoops = true;
			debugKeepAlive = true;
		}
		
		// get startup delay
		Integer newStartupDelay = ParseArgs.getInteger(args, "-sdelay");
		if (newStartupDelay != null)
			plannedStartupDelay = newStartupDelay.intValue();
		
		// get max. parallel threads per user - note: only valid if CONTAINS_PARALLEL_EXECUTED_URLS = true
		Integer newMaxParallelThreadsPerUser = ParseArgs.getInteger(args, "-mtpu");
		if (newMaxParallelThreadsPerUser != null)
		{
			if (newMaxParallelThreadsPerUser.intValue() > 0)
				maxParallelThreadsPerUser = newMaxParallelThreadsPerUser.intValue();
		}
		// get maximum number of loops per user
		maxPlannedLoops = 0;  // maximum loops per user, 0 = unlimited
		Integer newLoops = ParseArgs.getInteger(args, "-maxloops");
		if (newLoops != null)
			maxPlannedLoops = newLoops.intValue();
		
		// get maximum downlink network bandwidth per user (default = unlimited)
		Integer newDownlinkBandwidth = ParseArgs.getInteger(args, "-downlink");
		if (newDownlinkBandwidth != null)
			downlinkBandwidth = newDownlinkBandwidth.intValue();
		
		// get maximum uplink network bandwidth per user (default = unlimited)
		Integer newUplinkBandwidth = ParseArgs.getInteger(args, "-uplink");
		if (newUplinkBandwidth != null)
			uplinkBandwidth = newUplinkBandwidth.intValue();
		
		// get statistic sampling interval
		int samplingInterval = 15;  // statistic sampling interval in seconds
		Integer newSamplingInterval = ParseArgs.getInteger(args, "-sampling");
		if (newSamplingInterval != null)
			samplingInterval = newSamplingInterval.intValue();
		
		// get additional sampling rate per web page call
		int percentilePageSampling = 100;  // additional sampling rate per web page call in percent
		Integer newPercentilePageSampling = ParseArgs.getInteger(args, "-percpage");
		if (newPercentilePageSampling != null)
			percentilePageSampling = newPercentilePageSampling.intValue();
		
		// get additional sampling rate per url call
		int percentileUrlSampling = 0;  // additional sampling rate per url call in percent
		Integer newPercentileUrlSampling = ParseArgs.getInteger(args, "-percurl");
		if (newPercentileUrlSampling != null)
			percentileUrlSampling = newPercentileUrlSampling.intValue();
		
		// get extended sampling level per url call
		int percentileUrlSamplingAddOption = 0;  // extended sampling level per url call, 0 = disabled
		Integer newPercentileUrlSamplingAddOption = ParseArgs.getInteger(args, "-percurlopt");
		if (newPercentileUrlSamplingAddOption != null)
			percentileUrlSamplingAddOption = newPercentileUrlSamplingAddOption.intValue();
		
		// get maximum number of error snapshots per URL (0 = unlimited)
		int maxErrorSnapshots = 0;
		Integer newMaxErrorSnapshots = ParseArgs.getInteger(args, "-maxerrsnap");
		if (newMaxErrorSnapshots != null)
			maxErrorSnapshots = newMaxErrorSnapshots.intValue();
		
		// get maximum memory in megabytes which can be used for error snapshots (-1 = unlimited, default = 10)
		long maxErrorSnapshotMemory = 20;
		Long newMaxErrorSnapshotMemory = ParseArgs.getLong(args, "-maxerrmem");
		if (newMaxErrorSnapshotMemory != null)
			maxErrorSnapshotMemory = newMaxErrorSnapshotMemory.longValue();
		
		// single user mode ?
		boolean singleUserMode = ParseArgs.hasOption(args, "-singleuser");
		
		// override value for http user agent field ?
		String setUserAgentStr = ParseArgs.getIgnoreCaseString(args, "-setuseragent");
		if (setUserAgentStr != null)
		{
			USER_AGENT_1 = setUserAgentStr;
		}
		// get required input arguments
		int concurrentUsers = 0;     // number of concurrent users
		plannedRequestTimeout = 0;   // request timeout in seconds
		
		System.out.println();
		
		// parse -u argument or ask --> <number of concurrent users>
		Integer i = ParseArgs.getIntegerOrAsk(args, "-u", "Concurrent Users, <RETURN>=1 : ", new Integer(1));
		if (i == null)
			System.exit(-1);
		else
			concurrentUsers = i.intValue();
		
		// parse -d argument or ask --> <test duration in seconds>
		i = ParseArgs.getIntegerOrAsk(args, "-d", "Test Duration in Seconds, <RETURN>=30 : ", new Integer(30));
		if (i == null)
			System.exit(-1);
		else
			plannedTestDuration = i.intValue();
		
		// parse -t argument or ask --> <request timeout in seconds>
		i = ParseArgs.getIntegerOrAsk(args, "-t", "HTTP Request Timeout per URL in Seconds, <RETURN>=60 : ", new Integer(60));
		if (i == null)
			System.exit(-1);
		else
			plannedRequestTimeout = i.intValue();
		
		// parse optional -tconnect argument (TCP/IP socket connect timeout in seconds)
		i = ParseArgs.getInteger(args, "-tconnect");
		if (i != null)
			plannedConnectTimeout = i.intValue();
		
		String genericFileName = PerformanceData.proposeFileName("WFSReportSM", concurrentUsers, ParseArgs.getString(args, "-executionPlan"));
		
		// auto-configure binary result file
		if (!ParseArgs.hasOption(args, "-nores"))
		{
			String newResultFile = ParseArgs.getString(args, "-res");
			if (newResultFile == null)
				resultFile = genericFileName + ".prxres";
			else
				resultFile = newResultFile;
			System.out.println("Result File : " + resultFile);
		}
		
		// display common arguments at console output
		System.out.println();
		System.out.println("# concurrent users = " + concurrentUsers);
		System.out.println("# max. parallel threads per user = [serial execution order for all URLs]");
		System.out.print("# planned test duration = ");
		if (plannedTestDuration == 0)
			System.out.println("unlimited");
		else
			System.out.println("" + plannedTestDuration + " seconds");
		System.out.println("# http request timeout = " + plannedRequestTimeout + " seconds");
		if (plannedConnectTimeout != 0)
			System.out.println("# tcp/ip socket connect timeout = " + plannedConnectTimeout + " seconds");
		System.out.println("# startup delay = " + plannedStartupDelay + " milliseconds");
		System.out.println("# statistic sampling interval = " + samplingInterval + " seconds");
		System.out.println("# additional sampling rate per web page call = " + percentilePageSampling + " %");
		System.out.println("# additional sampling rate per url call = " + percentileUrlSampling + " %");
		System.out.println("# extended sampling per url call = " + PerformanceDataTickExtension.extTypeToString(percentileUrlSamplingAddOption).toLowerCase());
		System.out.print("# max loops per user = ");
		if (maxPlannedLoops == 0)
			System.out.println("unlimited");
		else
			System.out.println("" + maxPlannedLoops + " loops");
		if (downlinkBandwidth > 0)
			System.out.println("# max downlink bandwidth per user = " + downlinkBandwidth + " kbps");
		if (uplinkBandwidth > 0)
			System.out.println("# max uplink bandwidth per user = " + uplinkBandwidth + " kbps");
		System.out.println("# http protocol version = v" + httpProtocolVersion);
		System.out.println("# ssl protocol version = " + sslProtocolVersion);
		if (sslSessionCacheTimeout != 0)
			System.out.println("# ssl session cache timeout = " + sslSessionCacheTimeout + " seconds");
		else
			System.out.println("# ssl session cache disabled");
		if (resultFile != null)
			System.out.println("# result file = " + resultFile);
		else
			System.out.println("# no result file");
		if (debugFailedLoops)
			System.out.println("# debug failed loops");
		if (debugLoops)
			System.out.println("# debug loops");
		if (debugHttp)
			System.out.println("# debug http protocol headers");
		if (debugContent)
			System.out.println("# debug http content data");
		if (debugCookies)
			System.out.println("# debug cookies");
		if (debugKeepAlive)
			System.out.println("# debug keep-alive (socket pool)");
		if (debugSsl)
			System.out.println("# debug ssl (https)");
		
		
		// ----------------------------
		// *** initialize load test ***
		// ----------------------------
		
		
		// initialize performance data
		// ---------------------------
		final int PAGE_BREAKS = 6;  // number of page breaks in execute()  - modify this value if you add or delete some page breaks
		final int MAX_THREAD_STEPS = 101;  // number of URL requests in execute() - modify this value if you add or delete some requests
		performanceData = new PerformanceData(PAGE_BREAKS, MAX_THREAD_STEPS, concurrentUsers, -1, plannedTestDuration, maxPlannedLoops, httpProtocolVersion, plannedStartupDelay, plannedRequestTimeout, samplingInterval, percentilePageSampling, percentileUrlSampling, percentileUrlSamplingAddOption);
		performanceData.setInfoText("WFSReportSM");
		performanceData.setExecutorsAnnotation(testRunAnnotation);
		if (commonNextProxyConfig != null)
		{
			performanceData.setProxyInfo(proxyHttpHost, proxyHttpPort, proxyHttpsHost, proxyHttpsPort);
			performanceData.addTestDescription("*** Warning: Load test executed via outbound proxy ***");
		}
		performanceData.setResultFileName(resultFile);
		performanceData.setDumpStream(System.out, "# ");
		performanceData.setMaxErrorSnapshots(maxErrorSnapshots);		// 0 = unlimited
		if (maxErrorSnapshotMemory >= 0)
			performanceData.setMaxErrorSnapshotsMemory(maxErrorSnapshotMemory * 1048576l);		// value in bytes
		
		if (sslECC)
			performanceData.addTestDescription("*** Warning: SSL/TLS option -ecc enabled ***");
		
		if ((downlinkBandwidth != 0) || (uplinkBandwidth != 0))
		{
			String downlinkBandwidthStr = "unlimited";
			String uplinkBandwidthStr = "unlimited";
			
			if (downlinkBandwidth != 0)
				downlinkBandwidthStr = "" + downlinkBandwidth + " kbps";
			if (uplinkBandwidth != 0)
				uplinkBandwidthStr = "" + uplinkBandwidth + " kbps";
			
			performanceData.addTestDescription("*** Warning: Max. network bandwidth per user limited. downlink = " + downlinkBandwidthStr + ", uplink = " + uplinkBandwidthStr + " ***");
		}
		
		if ((percentileUrlSamplingAddOption != PerformanceDataTickExtension.EXT_TYPE_NOTYPE) && (percentileUrlSampling > 0))
			performanceData.addTestDescription("*** Warning: Option \"" + PerformanceDataTickExtension.extTypeToString(percentileUrlSamplingAddOption).toLowerCase() + "\" enabled for additional sampling rate per URL call ***");
		if (debugFailedLoops)
			performanceData.addTestDescription("*** Warning: Debug failed loops enabled ***");
		if (debugLoops)
			performanceData.addTestDescription("*** Warning: Debug loops enabled ***");
		if (debugHttp)
			performanceData.addTestDescription("*** Warning: Debug HTTP protocol headers enabled ***");
		if (debugContent)
			performanceData.addTestDescription("*** Warning: Debug HTTP content data enabled ***");
		if (debugCookies)
			performanceData.addTestDescription("*** Warning: Debug cookies enabled ***");
		if (debugKeepAlive)
			performanceData.addTestDescription("*** Warning: Debug keep-alive enabled ***");
		if (debugSsl)
			performanceData.addTestDescription("*** Warning: Debug SSL/TLS enabled ***");
		if (!sslProtocolVersion.equalsIgnoreCase("all"))
			performanceData.addTestDescription("*** Warning: SSL/TLS protocol version fixed to " + sslProtocolVersion.toUpperCase() + " ***");
		if (sslSessionCacheTimeout == 0)
			performanceData.addTestDescription("*** Warning: SSL/TLS session cache disabled ***");
		if (singleUserMode)
		{
			String singleUserModeWarning = "*** Warning: Single user mode enabled ***";
			System.out.println(singleUserModeWarning);
			performanceData.addTestDescription(singleUserModeWarning);
		}
		if (setUserAgentStr != null)
		{
			String overrideUserAgentWarning = "*** Warning: User agent set to \"" + setUserAgentStr + "\" ***";
			System.out.println(overrideUserAgentWarning);
			performanceData.addTestDescription(overrideUserAgentWarning);
		}
		
		
		// ready to start load test...
		initNull(concurrentUsers);
		performanceData.setUserContextTable(getUserContextTable());
		
		// ... but init first remote interface ...
		initRemote(args);
		
		// ... and init plug-in class loader ...
		try
		{
			if (getPluginClassLoader() == null)
				setPluginClassLoader(new LoadtestPluginClassLoader(getSymmetricEncryptContext(), getEncryptedClasspathList()));
		}
		catch (Throwable pluginClassLoaderThrowable)
		{
			System.out.println("*** ERROR: Unable to load encrypted files ***");
			pluginClassLoaderThrowable.printStackTrace();
			System.exit(-1);
		}
		
		// ... and check multihomed option ...
		initMultihomed(args);
		
		// ... and add dynaTrace session ID to load test result - if available ...
		initDynaTrace();
		
		
		// use test-specific DNS hosts file (optional) ?
		String dnsHostsFile = ParseArgs.getIgnoreCaseString(args, "-dnshosts");
		if (dnsHostsFile != null)
		{
			try
			{
				dnsCache = new DNSCache(getSymmetricEncryptContext(), dnsHostsFile);
			}
			catch (IOException ie)
			{
				System.out.println("*** ERROR: unable to read DNS hosts file " + dnsHostsFile + " ***");
				System.out.println("*** Hint: you have to ZIP " + dnsHostsFile + " together with the compiled class of the load test program ***");
				ie.printStackTrace();
				System.exit(-1);
			}
		}
		
		// use test-specific DNS translation table (optional) ?
		String dnsTranslationTableFile = ParseArgs.getIgnoreCaseString(args, "-dnstranslation");
		if (dnsTranslationTableFile != null)
		{
			try
			{
				DNSTranslationTable dnsTranslationTable = new DNSTranslationTable(getSymmetricEncryptContext(), new File(dnsTranslationTableFile));
				if (dnsCache == null)
					dnsCache = new DNSCache();
				dnsCache.setDNSTranslationTable(dnsTranslationTable);
			}
			catch (IOException ie)
			{
				System.out.println("*** ERROR: unable to read DNS translation table file " + dnsTranslationTableFile + " ***");
				System.out.println("*** Hint: you have to ZIP " + dnsTranslationTableFile + " together with the compiled class of the load test program ***");
				ie.printStackTrace();
				System.exit(-1);
			}
		}
		
		// use test-specific DNS servers (optional) ?
		String dnsSrvStr = ParseArgs.getIgnoreCaseString(args, "-dnssrv");
		if (dnsSrvStr != null)
		{
			ArrayList<String> dnsSrvList = new ArrayList<String>();
			StringTokenizer dnsTok = new StringTokenizer(dnsSrvStr, ",;");
			while (dnsTok.hasMoreTokens())
				dnsSrvList.add(dnsTok.nextToken());
			if (dnsCache == null)
				dnsCache = new DNSCache(dnsSrvList);
			else
				dnsCache.setDnsServers(dnsSrvList);
		}
		
		// enable DNS TTL ?
		if (ParseArgs.hasOption(args, "-dnsenattl"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.enableTTL();
		}
		
		// set fixed DNS TTL ?
		Integer dnsFixTTL = ParseArgs.getInteger(args, "-dnsfixttl");
		{
			if (dnsFixTTL != null)
			{
				if (dnsCache == null)
					dnsCache = new DNSCache();
				dnsCache.setFixedTTL(dnsFixTTL.intValue());
			}
		}
		
		// enable DNS resolves per loop ?
		if (ParseArgs.hasOption(args, "-dnsperloop"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsPerLoop = true;
		}
		
		// enable DNS statistic ?   // note: use this option only if not any other, more specific DNS option is enabled.
		if (ParseArgs.hasOption(args, "-dnsstatistic"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
		}
		
		// debug DNS resolver ?
		if (ParseArgs.hasOption(args, "-dnsdebug"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setDebugToStdout(true);
		}
		
		// enable IPv6 
		if (ParseArgs.hasIgnoreCaseOption(args, "-enableIPv6"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setEnableIPv6(true);
			String networkInterfaceName = ParseArgs.getString(args, "-enableIPv6");
			if(null != networkInterfaceName && !networkInterfaceName.startsWith("-"))
				dnsCache.setNetworkInterfaceName(networkInterfaceName);
		}
		
		// enable IPv6 and V4 
		if (ParseArgs.hasIgnoreCaseOption(args, "-enableIPv6v4"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setEnableIPv6v4(true);
			String networkInterfaceName = ParseArgs.getString(args, "-enableIPv6v4");
			if(null != networkInterfaceName && !networkInterfaceName.startsWith("-"))
				dnsCache.setNetworkInterfaceName(networkInterfaceName);
		}
		
		if (dnsCache != null)
		{
			// update performance data with DNS settings
			performanceData.addDNSCacheStatistic(dnsCache.getCacheStatistic());
			performanceData.addTestDescription("*** Warning: OS-independent DNS access enabled. " + dnsCache.getConfigInfoText() + " ***");
			if (dnsPerLoop)
				performanceData.addTestDescription("*** Warning: DNS option -dnsperloop enabled ***");
			
			// log DNS settings
			System.out.println("# OS-independent DNS access enabled. " + dnsCache.getConfigInfoText());
			if (dnsPerLoop)
				System.out.println("# DNS option -dnsperloop enabled");
		}
		
		// initialize input files
		try
		{
			Login_txt = new VarInputFileReader(getSymmetricEncryptContext(), "Login.txt", "#", ",", AbstractInputFileReader.EOF_REOPEN_FILE, prxCharEncoding);
			Login_txt.setTrimValues(true);
		}
		catch (IOException ie)
		{
			System.out.println("*** ERROR: UNABLE TO OPEN INPUT FILE ***");
			ie.printStackTrace();
			System.exit(-2);
		}
		
		// calculate sampling offset and virtual user startup offset for cluster jobs (time shift per cluster member)
		int samplingTimeshift = 0;	// value in seconds
		if (!ParseArgs.hasOption(args, "-nosdelayCluster"))
		{
			if ((getClusterTotalMemberCount() > 1) && (getClusterMemberLocalId() > 0))
			{
				samplingTimeshift = Math.round(((float) samplingInterval / (float) getClusterTotalMemberCount()) * (float) getClusterMemberLocalId());
				System.out.println("# samplingTimeshift = " + samplingTimeshift + " seconds");
				
				long startupDelayOffset = (plannedStartupDelay / ((long) getClusterTotalMemberCount())) * ((long) getClusterMemberLocalId());
				System.out.println("# startupDelayTimeshift = " + startupDelayOffset + " milliseconds");
				System.out.println();
				if (startupDelayOffset > 0)
				{
					try { sleepRemoteInterruptable(startupDelayOffset); } catch (InterruptedException ie) {}
				}
			}
		}
		
		
		// update performance data
		// -----------------------
		testDurationStart = System.currentTimeMillis();
		performanceData.setStartDate();
		performanceData.addSnapshot(getCpuUsagePercent());
		performanceData.setSnapshotsTimeshift(samplingTimeshift);
		performanceData.setEndDate();
		
		// initialize global context for plug-ins  
		LoadtestPluginContext globalPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, new WFSReportSM());
		
		
		// --------------------------
		// *** start of load test ***
		// ---------------------------
		
		
		// special case for execution plans - start test with zero virtual users
		// ---------------------------------------------------------------------
		if (hasExecutionPlan())
		{
			if (concurrentUsers != 0)
			{
				System.out.println("*** Fatal Error: Load test with execution plan must start with zero number of virtual users - Load test program aborted ***");
				System.exit(1);
			}
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				WFSReportSM simulatedUser = new WFSReportSM(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				
				HttpLoadTestUserContext userContext = new HttpLoadTestUserContext(simulatedUser, null);
				userContext.setLoadTestUserExecutionPlanPlaceholder();
				getUserContextTable().getUserContextList().add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
		}
		
		
		// start virtual users as threads (normal case)
		// --------------------------------------------
		usersToBeIncreasedAtStartupOffset.set(concurrentUsers);
		for (int x = 0; x < concurrentUsers; x++)
		{
			if (cancelIncrementDecrementUser || cancelInitialIncrementUser)
			{
				usersToBeIncreasedAtStartupOffset.set(0);
				break;
			}
			
			// start load test thread
			// ----------------------
			Thread t = null;
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				WFSReportSM simulatedUser = new WFSReportSM(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				t = new Thread(simulatedUser);
				String threadName = "" + getUserContextTable().getUserContextList().size();
				threadName = THREAD_NAME.substring(0, 7 - threadName.length()) + threadName;
				t.setName(threadName);
				if (debugLoops && (simulatedUser.getLog().size() > 0))
				{
					synchronized (dumpLock)
					{
						simulatedUser.dumpLog(threadName + " ", System.out);		// dump log of constructor
					}
				}
				HttpLoadTestUserContext userContext = new HttpLoadTestUserContext(simulatedUser, t);
				getUserContextTable().getUserContextList().add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
			t.start();
			usersToBeIncreasedAtStartupOffset.decrementAndGet();
			System.out.println("# --- thread " + t.getName() + " created --- " + ZoneTime.dateToShortString() + " ---");
			
			while (isSuspend())
			{
				try { Thread.currentThread().sleep(100); } catch (InterruptedException ie) { break; }
				if (abortedByRemote() || abortedByEofInputFile())
					break;
				
				// check if max test duration reached during suspend
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
					break;
				
				// display and sample temporary performance data all "sampling interval" seconds - also during suspend
				if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
				{
					performanceData.addSnapshot(getCpuUsagePercent());
					performanceData.setEndDate();
				}
			}
			
			if (abortedByRemote() || abortedByEofInputFile())
				break;
			
			if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				break;
			
			// startup delay for next thread
			// -----------------------------
			try
			{
				if (!singleUserMode)   // create concurrent users
				{
					if (plannedStartupDelay <= 3000)
						sleepRemoteInterruptable(plannedStartupDelay);
					else
					{
						long startupDelayStartTime = System.currentTimeMillis();
						while (true)
						{
							if (abortedByRemote() || abortedByEofInputFile())
								break;
							if ((System.currentTimeMillis() - startupDelayStartTime) >= plannedStartupDelay)
								break;
							
							Thread.currentThread().sleep(100);
							
							// display and sample temporary performance data all "sampling interval" seconds
							if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
							{
								performanceData.addSnapshot(getCpuUsagePercent());
								performanceData.setEndDate();
							}
						}
						while (isSuspend())
						{
							try { Thread.currentThread().sleep(100); } catch (InterruptedException ie) { break; }
							if (abortedByRemote() || abortedByEofInputFile())
								break;
							
							// check if max test duration reached during suspend
							if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
								break;
							
							// display and sample temporary performance data all "sampling interval" seconds - also during suspend
							if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
							{
								performanceData.addSnapshot(getCpuUsagePercent());
								performanceData.setEndDate();
							}
						}
						
					}
				}
				else
					t.join();   // single user mode
			}
			catch (InterruptedException ie) { break; }
			if (abortedByRemote() || abortedByEofInputFile())
				break;
			
			
			// display and sample temporary performance data all "sampling interval" seconds
			if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
			{
				performanceData.addSnapshot(getCpuUsagePercent());
				performanceData.setEndDate();
				if (!isRemote())
				{
					synchronized (dumpLock)
					{
						performanceData.dump(false);
					}
				}
			}
		}
		usersToBeIncreasedAtStartupOffset.set(0);	// just in case that a thread is not started for any reason
		
		
		// wait for test-end in a loop
		// ---------------------------
		boolean allDone = false;
		while (!allDone)
		{
			// test aborted ?
			if (abortedByRemote() || abortedByEofInputFile())
			{
				nearRemoteEnd();
				String abort = "";
				if (abortedByRemote())
					abort = "*** test aborted by remote command ***";
				if (abortedByEofInputFile())
				{
					abort = "*** test aborted at eof of input file ***";
					performanceData.addTestDescription(abort);
				}
				synchronized (dumpLock)
				{
					addSSLCacheStatistic();
					performanceData.addSnapshot(getCpuUsagePercent());
					performanceData.setEndDate();
					
					if (!isRemote())
						performanceData.dump(false);
					if (resultFile != null)
						try { performanceData.writeObjectToFile(getSymmetricEncryptContext(), resultFile); } catch (IOException ie) { ie.printStackTrace(); }
					
					System.out.println();
					System.out.println(abort);
					System.out.println();
					System.out.flush();
					try { Thread.currentThread().sleep(10000); } catch (InterruptedException ie) {}
					System.exit(0);
				}
			}
			
			// display and sample temporary performance data all "sampling interval" seconds
			if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
			{
				performanceData.addSnapshot(getCpuUsagePercent());
				performanceData.setEndDate();
				if (!isRemote())
				{
					synchronized (dumpLock)
					{
						performanceData.dump(false);
					}
				}
			}
			
			// check if test has been done in case of decrement users to zero
			if ((decrementUser) && (plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				decrementUser = false;
			// check if test has been done
			if (!hasExecutionPlan())
				allDone = isTestDone();
			else
			{
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				{
					performanceData.addTestDescription("*** Warning: Load test aborted. Execution plan time limit exceeded after " + plannedTestDuration + " seconds ***");
					triggerAbort();
				}
			}
			
			// if not all is done: sleep one second
			if (!allDone)
				try { sleepRemoteInterruptable(1000); } catch (InterruptedException ie) { break; }
		} // end of wait loop
		
		
		// mark near end of test - only if a remote interface has been used
		nearRemoteEnd();
		
		
		
		// final test result - test completed
		// ----------------------------------
		performanceData.addSnapshot(getCpuUsagePercent());
		performanceData.setEndDate();
		
		// save test result
		performanceData.dump(true);
		if (resultFile != null)
			try { performanceData.writeObjectToFile(getSymmetricEncryptContext(), resultFile); } catch (IOException ie) { ie.printStackTrace(); }
		
		// all done
		System.out.flush();
		
		// wait for official end of test - only if a remote interface has been used
		waitRemoteEnd();
		
		System.out.println();
		System.out.println("Result File: " + resultFile);
		
		// now dead
		System.exit(0);
	}


	/**
	 * implement VaryingLoadInterface: support to increment the number of simulated users at runtime.
	 */
	public void setIncrementUser(long startTime)
	{
		incrementUserStartTime = startTime;
		incrementUserFlag = true;
	}

	public boolean isIncrementUser()
	{
		return incrementUserFlag;
	}

	public long getIncrementUserStartTime()
	{
		return incrementUserStartTime;
	}

	public void setIncrementUserStartTime(long startTime)
	{
		incrementUserStartTime = startTime;
	}

	public void clearIncrementUser()
	{
		incrementUserFlag = false;
	}

	public int incrementUsers(int numAddUsers, long startupDelay)
	{
		if (startupDelay < 0)
			startupDelay = plannedStartupDelay;
		return incrementUsersImplementation(numAddUsers, startupDelay, this);
	}

	static int incrementUsersImplementation(int numAddUsers, long startupDelay, HttpLoadTest httpLoadTest)
	{
		long startupDelayOffset = 0;
		if ((getClusterTotalMemberCount() > 1) && (getClusterMemberLocalId() > 0))
			startupDelayOffset = (startupDelay / ((long) getClusterTotalMemberCount())) * ((long) getClusterMemberLocalId());
		
		ArrayList<HttpLoadTestUserContext> addUserContextList = new ArrayList<HttpLoadTestUserContext>(numAddUsers);
		for (int x = 0; x < numAddUsers; x++)
		{
			if (abortedByRemote() || abortedByEofInputFile())
				return x;
			
			// initialize load test thread
			// ---------------------------
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				WFSReportSM simulatedUser = new WFSReportSM(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				HttpLoadTestUserContext userContext = prepareIncrementUser(simulatedUser, System.currentTimeMillis() + startupDelayOffset + (x * startupDelay));
				addUserContextList.add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
				if (debugLoops && (simulatedUser.getLog().size() > 0))
				{
					synchronized (dumpLock)
					{
						simulatedUser.dumpLog(userContext.getLoadTestThread().getName() + " ", System.out);		// dump log of constructor
					}
				}
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
		}
		
		// start load test threads by a thread
		// -----------------------------------
		HttpLoadTestIncrementUserThread incrementUserThread = new HttpLoadTestIncrementUserThread(httpLoadTest, addUserContextList);
		incrementUserThread.start();
		return numAddUsers;
	}


	/**
	 * Internal method used to load and apply next proxy settings from ZBAProxySettings.properties file.
	 * Settings are applied only if file exists and nextProxyIsActive is set to true in the file.
	 * Note that settings stored with the session, will be ineffective.
	 *
	 * @since V5.5-D
	 */
	private void applyNextProxySettingsFromFileIfExists()
	{
		
		String filename = "ZBAProxySettings.properties";
		BufferedReader bin = null;
		SymmetricEncryptContext decryptContext = getSymmetricEncryptContext();
		File file = new File(filename);
		
		if (file.exists())
		// open input file
		try
		{
			if (decryptContext == null)
			{
				bin = new BufferedReader(new InputStreamReader(new FileInputStream(filename), Charset.forName("UTF-8")));
			}
			else
			{
				// create a reader stream that decrypts the data on the fly
				bin = new BufferedReader(new InputStreamReader(SymmetricEncrypt.getCipherInputStream(new FileInputStream(filename), decryptContext), Charset.forName("UTF-8")));
			}
			
			if (bin != null)
			{
				Properties nextProxyConfigProperties = new Properties();
				nextProxyConfigProperties.load(bin);
				NextProxyConfig nextProxyConfig = new NextProxyConfig();
				nextProxyConfig.setActive(Boolean.valueOf(nextProxyConfigProperties.getProperty("nextProxyIsActive")));
				proxyEnabled = nextProxyConfig.isActive();                             // if false: do not use a proxy server
				
				if (proxyEnabled)
				{
					nextProxyConfig.disableHttpProxyCache(Boolean.valueOf(nextProxyConfigProperties.getProperty("nextProxyHttpCacheDisabled")));
					proxyCacheDisabled = nextProxyConfig.isDisabledHttpProxyCache();
					nextProxyConfig.setHttpHost(nextProxyConfigProperties.getProperty("nextProxyHttpHost"));
					proxyHttpHost = nextProxyConfig.getHttpHost();
					nextProxyConfig.setHttpPort(Integer.valueOf(nextProxyConfigProperties.getProperty("nextProxyHttpPort")));
					proxyHttpPort = nextProxyConfig.getHttpPort();
					nextProxyConfig.setHttpsHost(nextProxyConfigProperties.getProperty("nextProxyHttpsHost"));
					proxyHttpsHost = nextProxyConfig.getHttpsHost();
					nextProxyConfig.setHttpsPort(Integer.valueOf(nextProxyConfigProperties.getProperty("nextProxyHttpsPort")));
					proxyHttpsPort = nextProxyConfig.getHttpsPort();
					nextProxyConfig.setAuthUsername(nextProxyConfigProperties.getProperty("nextProxyAuthUsername"));
					nextProxyConfig.setAuthPassword(nextProxyConfigProperties.getProperty("nextProxyAuthPassword"));
					nextProxyConfig.setNoNextProxy(nextProxyConfigProperties.getProperty("noNextProxy"));
					noProxyFor = nextProxyConfig.getNoNextProxy();
					
					String proxyAuth = "";
					
					if (nextProxyConfig.getAuthUsername() != null)
					{
						proxyAuth = nextProxyConfig.getAuthUsername() + ":";
						if (nextProxyConfig.getAuthPassword() != null)
							proxyAuth = proxyAuth + nextProxyConfig.getAuthPassword();
					}
					
					String  proxyAuthorization = null;
					
					if (proxyAuth.length() > 1)
						proxyAuthorization = Base64Encoder.encode(proxyAuth);		// Base 64 encoded - used for basic authentication only
					
					commonNextProxyConfig = new NextProxyConfig(proxyEnabled, proxyCacheDisabled, proxyHttpHost, proxyHttpPort, proxyHttpsHost, proxyHttpsPort, proxyAuthorization, noProxyFor);
					
					log("*** Warning: Applying proxy configuration from file " + filename + " ***");
				}
				
			}
		}
		catch (Throwable tr)
		{
			log("*** Unable to load proxy configuration from properties file " + filename + " ***");
			tr.printStackTrace();
		}
		finally
		{
			if (bin != null)
			{
				try { bin.close(); } catch (Exception e) {}
			}
		}
		
	}
		
	
	// source code of inline script "tzoffsetCookie"
	public static String getInlineScriptCode_1573614890836()
	{
		return "setCookieValue(\"TZ_OFFSET\",\"-28800000\")";
	}
	
	
	/**
	* Execute the inline script "tzoffsetCookie"
	* 
	* @param testURL 	the context of the executed URL call
	* @param threadStep 	the current execution step of the simulated user (page break or URL call)
	* @param totalLoopCounter 	the total number of executed loops - counted overall simulated users
	* @param innerLoopContext 	the context of the current inner loop, or null if the inline script in not executed inside an inner loop
	*
	* @return the context of the inline script
	*/
	public LoadtestInlineScriptContext executeInlineScript_1573614890836(HttpTestURL testURL, int threadStep, int totalLoopCounter, InnerLoopContext innerLoopContext)
	{
		LoadtestInlineScriptContext inlineScriptContext = new LoadtestInlineScriptContext("tzoffsetCookie", ProxySnifferVarSourceInlineScript.EXEC_SCOPE_ALL_URLS_START, "", this, LoadtestInlineScriptContext.RESULT_TYPE_SET_OUTPUT_VARS, 15, threadNumber, threadLoopCounter, socketPool, cookieHandler, testURL, threadStep);
		InlineScriptExecutor inlineScriptExecutor = new InlineScriptExecutor(getInlineScriptCode_1573614890836(), inlineScriptContext);
		log("Executing inline script \"" + inlineScriptContext.getScriptTitle() + "\"");
		inlineScriptExecutor.execute();		// execute inline script
		for (String stdoutLine : inlineScriptContext.getOutputStreamData())
			log(inlineScriptContext.getScriptTitle() + ": " + stdoutLine);
		for (String stderrLine : inlineScriptContext.getErrorStreamData())
			System.err.println(inlineScriptContext.getScriptTitle() + ": " + stderrLine);
		if (!inlineScriptExecutor.wasSuccessFulExecution())
		{
			if (!inlineScriptContext.isScriptAbort())
				throw new InlineScriptExecutionException("*** Execution of inline script \"" + inlineScriptContext.getScriptTitle() + "\" failed ***");
		}
		return inlineScriptContext;
	}

}	// end of class

