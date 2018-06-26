package opcDemoClient;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.opcfoundation.ua.builtintypes.DataValue;
import org.opcfoundation.ua.builtintypes.DateTime;
import org.opcfoundation.ua.builtintypes.DiagnosticInfo;
import org.opcfoundation.ua.builtintypes.ExpandedNodeId;
import org.opcfoundation.ua.builtintypes.LocalizedText;
import org.opcfoundation.ua.builtintypes.NodeId;
import org.opcfoundation.ua.builtintypes.QualifiedName;
import org.opcfoundation.ua.builtintypes.StatusCode;
import org.opcfoundation.ua.builtintypes.UnsignedInteger;
import org.opcfoundation.ua.builtintypes.UnsignedShort;
import org.opcfoundation.ua.builtintypes.Variant;
import org.opcfoundation.ua.common.ServiceResultException;
import org.opcfoundation.ua.core.AccessLevel;
import org.opcfoundation.ua.core.ApplicationDescription;
import org.opcfoundation.ua.core.ApplicationType;
import org.opcfoundation.ua.core.Argument;
import org.opcfoundation.ua.core.Attributes;
import org.opcfoundation.ua.core.BrowseDirection;
import org.opcfoundation.ua.core.BrowsePathTarget;
import org.opcfoundation.ua.core.DataChangeFilter;
import org.opcfoundation.ua.core.DataChangeTrigger;
import org.opcfoundation.ua.core.DeadbandType;
import org.opcfoundation.ua.core.EUInformation;
import org.opcfoundation.ua.core.ElementOperand;
import org.opcfoundation.ua.core.EndpointDescription;
import org.opcfoundation.ua.core.EventFilter;
import org.opcfoundation.ua.core.FilterOperator;
import org.opcfoundation.ua.core.HistoryEventFieldList;
import org.opcfoundation.ua.core.Identifiers;
import org.opcfoundation.ua.core.LiteralOperand;
import org.opcfoundation.ua.core.MonitoringMode;
import org.opcfoundation.ua.core.NodeClass;
import org.opcfoundation.ua.core.Range;
import org.opcfoundation.ua.core.ReferenceDescription;
import org.opcfoundation.ua.core.RelativePathElement;
import org.opcfoundation.ua.core.SimpleAttributeOperand;
import org.opcfoundation.ua.core.TimestampsToReturn;
import org.opcfoundation.ua.core.UserTokenPolicy;
import org.opcfoundation.ua.transport.security.HttpsSecurityPolicy;
import org.opcfoundation.ua.transport.security.KeyPair;
import org.opcfoundation.ua.transport.security.SecurityMode;
import org.opcfoundation.ua.utils.AttributesUtil;
import org.opcfoundation.ua.utils.CertificateUtils;
import org.opcfoundation.ua.utils.MultiDimensionArrayUtils;

import com.prosysopc.ua.ApplicationIdentity;
import com.prosysopc.ua.CertificateValidationListener;
import com.prosysopc.ua.ContentFilterBuilder;
import com.prosysopc.ua.EventNotifierClass;
import com.prosysopc.ua.MethodCallStatusException;
import com.prosysopc.ua.MonitoredItemBase;
import com.prosysopc.ua.PkiFileBasedCertificateValidator;
import com.prosysopc.ua.SecureIdentityException;
import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.SessionActivationException;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.UaAddress;
import com.prosysopc.ua.UaApplication.Protocol;
import com.prosysopc.ua.UserIdentity;
import com.prosysopc.ua.client.AddressSpaceException;
import com.prosysopc.ua.client.ConnectException;
import com.prosysopc.ua.client.InvalidServerEndpointException;
import com.prosysopc.ua.client.MonitoredDataItem;
import com.prosysopc.ua.client.MonitoredDataItemListener;
import com.prosysopc.ua.client.MonitoredEventItem;
import com.prosysopc.ua.client.MonitoredEventItemListener;
import com.prosysopc.ua.client.MonitoredItem;
import com.prosysopc.ua.client.ServerConnectionException;
import com.prosysopc.ua.client.ServerList;
import com.prosysopc.ua.client.ServerListException;
import com.prosysopc.ua.client.ServerStatusListener;
import com.prosysopc.ua.client.Subscription;
import com.prosysopc.ua.client.SubscriptionAliveListener;
import com.prosysopc.ua.client.SubscriptionNotificationListener;
import com.prosysopc.ua.client.UaClient;
import com.prosysopc.ua.client.UaClientListener;
import com.prosysopc.ua.nodes.MethodArgumentException;
import com.prosysopc.ua.nodes.UaDataType;
import com.prosysopc.ua.nodes.UaInstance;
import com.prosysopc.ua.nodes.UaMethod;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.nodes.UaObject;
import com.prosysopc.ua.nodes.UaReferenceType;
import com.prosysopc.ua.nodes.UaType;
import com.prosysopc.ua.nodes.UaVariable;
//import com.prosysopc.ua.samples.client.my1stOPCClient;
import com.prosysopc.ua.types.opcua.AnalogItemType;

/**
 * A sample OPC UA client, running from the console.
 */
public class OPCDemoClient {

	// Action codes for readAction, etc.
	protected static final int ACTION_ALL = -4;
	protected static final int ACTION_BACK = -2;
	protected static final int ACTION_RETURN = -1;
	protected static final int ACTION_ROOT = -3;
	protected static final int ACTION_TRANSLATE = -6;
	protected static final int ACTION_UP = -5;

	/**
	 * The name of the application.
	 */
	protected static String APP_NAME = "PlenkClient";

	protected final static List<String> cmdSequence = new ArrayList<String>();

	protected static boolean stackTraceOnException = false;
	
	protected UaClient client;

    public OPCDemoClient(String ClientURI) throws URISyntaxException, InvalidServerEndpointException, ConnectException, SessionActivationException, ServiceException, SecureIdentityException, IOException {
    	client = new UaClient(ClientURI);
    	
		// Use PKI files to keep track of the trusted and rejected server
		// certificates...
		final PkiFileBasedCertificateValidator validator = new PkiFileBasedCertificateValidator();
		client.setCertificateValidator(validator);
		// ...and react to validation results with a custom handler (to prompt
		// the user what to do, if necessary)
		//validator.setValidationListener(validationListener);

		// *** Application Description is sent to the server
		ApplicationDescription appDescription = new ApplicationDescription();
		// 'localhost' (all lower case) in the ApplicationName and
		// ApplicationURI is converted to the actual host name of the computer
		// in which the application is run
		appDescription.setApplicationName(new LocalizedText(APP_NAME + "@localhost"));
		appDescription.setApplicationUri("urn:localhost:OPCUA:" + APP_NAME);
		appDescription.setProductUri("urn:prosysopc.com:OPCUA:" + APP_NAME);
		appDescription.setApplicationType(ApplicationType.Client);

		// *** Certificates
		File privatePath = new File(validator.getBaseDir(), "private");

		// Create self-signed certificates
		KeyPair issuerCertificate = null;

		int[] keySizes = null;

		// *** Application Identity
		// Define the client application identity, including the security
		// certificate
		final ApplicationIdentity identity = ApplicationIdentity.loadOrCreateCertificate(appDescription,
				"Sample Organisation", /* Private Key Password */"opcua",
				/* Key File Path */privatePath,
				/* CA certificate & private key */issuerCertificate,
				/* Key Sizes for instance certificates to create */keySizes,
				/* Enable renewing the certificate */true);

		// Create the HTTPS certificate.
		// The HTTPS certificate must be created, if you enable HTTPS.
		String hostName = InetAddress.getLocalHost().getHostName();
		identity.setHttpsCertificate(ApplicationIdentity.loadOrCreateHttpsCertificate(appDescription, hostName, "opcua",
				issuerCertificate, privatePath, true));

		client.setApplicationIdentity(identity);

		// Define our user locale - the default is Locale.getDefault()
		client.setLocale(Locale.ENGLISH);

		// Define the call timeout in milliseconds. Default is null - to
		// use the value of UaClient.getEndpointConfiguration() which is
		// 120000 (2 min) by default
		client.setTimeout(30000);

		// StatusCheckTimeout is used to detect communication
		// problems and start automatic reconnection.
		// These are the default values:
		client.setStatusCheckTimeout(10000);
		// client.setAutoReconnect(true);

		// Define the security mode
		client.setSecurityMode(SecurityMode.NONE);

		// Define the security policies for HTTPS; ALL is the default
		client.getHttpsSettings().setHttpsSecurityPolicies(HttpsSecurityPolicy.ALL);

		// Set endpoint configuration parameters
		client.getEndpointConfiguration().setMaxByteStringLength(Integer.MAX_VALUE);
		client.getEndpointConfiguration().setMaxArrayLength(Integer.MAX_VALUE);

    	client.connect();
    	if (client.isConnected())
    		System.out.println("Client connected");
    	else
    		System.out.println("Client not connected");
    	  	
    }
	
    public NodeId recursiveSearch(NodeId nodeId, String nodeName) throws ServiceException, StatusException, ServiceResultException {
    	List<ReferenceDescription> references;

    	NodeId myNodeId = nodeId;
   		String[] terms = nodeName.split(":");
   	 
   		System.out.println("Search: "+terms[0]);
		
   		client.getAddressSpace().setMaxReferencesPerNode(1000);
    	references = client.getAddressSpace().browse(nodeId);
    	for (Iterator<ReferenceDescription> iterator = references.iterator(); iterator.hasNext();)
    	{
    		ReferenceDescription ref = iterator.next();
    		QualifiedName name = ref.getBrowseName();
    		if(name.getName().equals(terms[0])) {
    			System.out.println("Found: "+terms[0]);
        		System.out.println(ref);
    			if (terms.length == 1)
    				myNodeId = client.getAddressSpace().getNamespaceTable().toNodeId(ref.getNodeId());
    			else {
    				String search ="";
    				for(int i=1; i < terms.length;i++)
    					search = search + terms[i] + ":";
    				search = search.substring(0,search.length()-1);
    				myNodeId =  recursiveSearch(
    						client.getAddressSpace().getNamespaceTable().toNodeId(ref.getNodeId())
    						,search);
    			}
    		}
    	}
 		return myNodeId;
    }
    
    public void readNode() throws ServiceException, StatusException, InterruptedException, ServiceResultException {
		NodeId nodeId = Identifiers.RootFolder;
		DataValue name = client.readAttribute(nodeId, Attributes.BrowseName);
		System.out.println(name);

		System.out.println("Durchsuche Adressbaum");
		NodeId nodeId1 = recursiveSearch(nodeId, "Objects:Siemens_1:Standard-Variablentabelle:Zaehlerstand");
		client.readAttribute(nodeId1, Attributes.BrowseName);
		System.out.println(name);

		System.out.println("10 Aufrufe alle zwei Sekunden");
		for(int i = 0; i< 10; i++) {
			DataValue value = client.readAttribute(nodeId1, Attributes.Value);
			System.out.println(value.getValue());
			System.out.println(value.getServerTimestamp());
			
			Thread.sleep(2*1000);
		}

		System.out.println("Nodes aus parseNodeID, 5 Aufrufe im 10 Sekundentakt");
		nodeId1 = NodeId.parseNodeId("ns=3;s=Siemens_1.Standard-Variablentabelle.Zaehlerstand");
		name = client.readAttribute(nodeId1, Attributes.BrowseName);
		System.out.println(name);
		
		for(int i = 0; i< 5; i++) {
			DataValue value = client.readAttribute(nodeId1, Attributes.Value);
			System.out.println(value.getValue());
			System.out.println(value.getServerTimestamp());
			
			Thread.sleep(10*1000);
		}
		
    }
    
    public void disconnect() {
    	client.disconnect();
    }
    
    public static void main(String[] args) throws Exception {
		// Load Log4j configurations from external file
		PropertyConfigurator.configureAndWatch(OPCDemoClient.class.getResource("log.properties").getFile(), 5000);
		
		OPCDemoClient myClient = new OPCDemoClient(
				"opc.tcp://10.50.80.62:4980/SoftingOPC");

		myClient.readNode();
		
		myClient.disconnect();
		
		System.out.println("Thats all, folks...");
	}
}
