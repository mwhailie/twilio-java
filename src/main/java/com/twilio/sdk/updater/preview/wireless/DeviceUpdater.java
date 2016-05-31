/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.updater.preview.wireless;

import com.twilio.sdk.client.TwilioRestClient;
import com.twilio.sdk.converter.Promoter;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resource.RestException;
import com.twilio.sdk.resource.preview.wireless.Device;
import com.twilio.sdk.updater.Updater;

import java.net.URI;

public class DeviceUpdater extends Updater<Device> {
    private final String sid;
    private String alias;
    private String callbackMethod;
    private URI callbackUrl;
    private String friendlyName;
    private String simIdentifier;
    private String status;
    private String commandsCallbackMethod;
    private URI commandsCallbackUrl;

    /**
     * Construct a new DeviceUpdater.
     * 
     * @param sid The sid
     */
    public DeviceUpdater(final String sid) {
        this.sid = sid;
    }

    /**
     * The alias.
     * 
     * @param alias The alias
     * @return this
     */
    public DeviceUpdater setAlias(final String alias) {
        this.alias = alias;
        return this;
    }

    /**
     * The callback_method.
     * 
     * @param callbackMethod The callback_method
     * @return this
     */
    public DeviceUpdater setCallbackMethod(final String callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    /**
     * The callback_url.
     * 
     * @param callbackUrl The callback_url
     * @return this
     */
    public DeviceUpdater setCallbackUrl(final URI callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    /**
     * The callback_url.
     * 
     * @param callbackUrl The callback_url
     * @return this
     */
    public DeviceUpdater setCallbackUrl(final String callbackUrl) {
        return setCallbackUrl(Promoter.uriFromString(callbackUrl));
    }

    /**
     * The friendly_name.
     * 
     * @param friendlyName The friendly_name
     * @return this
     */
    public DeviceUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The sim_identifier.
     * 
     * @param simIdentifier The sim_identifier
     * @return this
     */
    public DeviceUpdater setSimIdentifier(final String simIdentifier) {
        this.simIdentifier = simIdentifier;
        return this;
    }

    /**
     * The status.
     * 
     * @param status The status
     * @return this
     */
    public DeviceUpdater setStatus(final String status) {
        this.status = status;
        return this;
    }

    /**
     * The commands_callback_method.
     * 
     * @param commandsCallbackMethod The commands_callback_method
     * @return this
     */
    public DeviceUpdater setCommandsCallbackMethod(final String commandsCallbackMethod) {
        this.commandsCallbackMethod = commandsCallbackMethod;
        return this;
    }

    /**
     * The commands_callback_url.
     * 
     * @param commandsCallbackUrl The commands_callback_url
     * @return this
     */
    public DeviceUpdater setCommandsCallbackUrl(final URI commandsCallbackUrl) {
        this.commandsCallbackUrl = commandsCallbackUrl;
        return this;
    }

    /**
     * The commands_callback_url.
     * 
     * @param commandsCallbackUrl The commands_callback_url
     * @return this
     */
    public DeviceUpdater setCommandsCallbackUrl(final String commandsCallbackUrl) {
        return setCommandsCallbackUrl(Promoter.uriFromString(commandsCallbackUrl));
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Device
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Device execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            TwilioRestClient.Domains.PREVIEW,
            "/wireless/Devices/" + this.sid + "",
            client.getAccountSid()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Device update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return Device.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (alias != null) {
            request.addPostParam("Alias", alias);
        }
        
        if (callbackMethod != null) {
            request.addPostParam("CallbackMethod", callbackMethod);
        }
        
        if (callbackUrl != null) {
            request.addPostParam("CallbackUrl", callbackUrl.toString());
        }
        
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        
        if (simIdentifier != null) {
            request.addPostParam("SimIdentifier", simIdentifier);
        }
        
        if (status != null) {
            request.addPostParam("Status", status);
        }
        
        if (commandsCallbackMethod != null) {
            request.addPostParam("CommandsCallbackMethod", commandsCallbackMethod);
        }
        
        if (commandsCallbackUrl != null) {
            request.addPostParam("CommandsCallbackUrl", commandsCallbackUrl.toString());
        }
    }
}