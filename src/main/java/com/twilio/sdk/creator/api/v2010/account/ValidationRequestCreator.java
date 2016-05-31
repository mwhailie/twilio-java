/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.creator.api.v2010.account;

import com.twilio.sdk.client.TwilioRestClient;
import com.twilio.sdk.converter.Promoter;
import com.twilio.sdk.creator.Creator;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resource.RestException;
import com.twilio.sdk.resource.api.v2010.account.ValidationRequest;

import java.net.URI;

public class ValidationRequestCreator extends Creator<ValidationRequest> {
    private final String accountSid;
    private final com.twilio.sdk.type.PhoneNumber phoneNumber;
    private String friendlyName;
    private Integer callDelay;
    private String extension;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;

    /**
     * Construct a new ValidationRequestCreator.
     * 
     * @param accountSid The account_sid
     * @param phoneNumber The phone_number
     */
    public ValidationRequestCreator(final String accountSid, 
                                    final com.twilio.sdk.type.PhoneNumber phoneNumber) {
        this.accountSid = accountSid;
        this.phoneNumber = phoneNumber;
    }

    /**
     * The friendly_name.
     * 
     * @param friendlyName The friendly_name
     * @return this
     */
    public ValidationRequestCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The call_delay.
     * 
     * @param callDelay The call_delay
     * @return this
     */
    public ValidationRequestCreator setCallDelay(final Integer callDelay) {
        this.callDelay = callDelay;
        return this;
    }

    /**
     * The extension.
     * 
     * @param extension The extension
     * @return this
     */
    public ValidationRequestCreator setExtension(final String extension) {
        this.extension = extension;
        return this;
    }

    /**
     * The status_callback.
     * 
     * @param statusCallback The status_callback
     * @return this
     */
    public ValidationRequestCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The status_callback.
     * 
     * @param statusCallback The status_callback
     * @return this
     */
    public ValidationRequestCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The status_callback_method.
     * 
     * @param statusCallbackMethod The status_callback_method
     * @return this
     */
    public ValidationRequestCreator setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created ValidationRequest
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public ValidationRequest execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            TwilioRestClient.Domains.API,
            "/2010-04-01/Accounts/" + this.accountSid + "/OutgoingCallerIds.json",
            client.getAccountSid()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("ValidationRequest creation failed: Unable to connect to server");
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
        
        return ValidationRequest.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (phoneNumber != null) {
            request.addPostParam("PhoneNumber", phoneNumber.toString());
        }
        
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        
        if (callDelay != null) {
            request.addPostParam("CallDelay", callDelay.toString());
        }
        
        if (extension != null) {
            request.addPostParam("Extension", extension);
        }
        
        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }
        
        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
        }
    }
}