package org.reactome.web.utils.analytics.client;

/**
 * Tracker - Google Universal Analytics
 *
 * Integrated as GWT module to load the analytics.js file and initialize the ga javascript variable
 *
 */
@SuppressWarnings("UnusedDeclaration")
public class GATracker {

    /**
     * Sets the web property ID for the tracking object.
     * @param accountID - The full web property ID (e.g. UA-65432-1) for the tracker object.
     * @param domain - The server name (e.g. "myserver.com") for the tracker object.
     */
    public static native void setAccount(String accountID, String domain) /*-{
        $wnd.ga('create', accountID, 'auto', {'legacyCookieDomain': domain});  // Replace with your property ID.
        $wnd.ga('send', 'pageview');
    }-*/;

    /**
     * Main logic for GATC (Google Analytic Tracker Code).
     * If linker functionalities are enabled, it attempts to extract cookie values from the URL.
     * Otherwise, it tries to extract cookie values from document.cookie.
     * It also updates or creates cookies as necessary, then writes them back to the document object.
     * Gathers all the appropriate metrics to send to the UCFE (Urchin Collector Front-end).
     */
    public static native void trackPageview() /*-{
        $wnd.ga('send', 'pageview');
    }-*/;

    //***************************************************************************************************
    //
    // EVENT TRACKING
    //
    // Event Tracking is a method available in the analytics.js tracking code that you can use to record
    // user interaction with website elements
    //
    //***************************************************************************************************

    /**
     * Track event
     * @param category 	- 	The name you supply for the group of objects you want to track.
     * @param action 	- 	A string that is uniquely paired with each category, and commonly used to
     * 						define the type of user interaction for the web object.
     * @param label 	- 	An optional string to provide additional dimensions to the event data.
     */
    public static native void trackEvent(String category, String action, String label) /*-{
        $wnd.ga('send', 'event', category, action, label);
    }-*/;
}

