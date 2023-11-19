package com.jaku.api;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.jaku.core.JakuRequest;
import com.jaku.core.JakuResponse;
import com.jaku.model.Channel;
import com.jaku.model.Device;
import com.jaku.model.Player;
import com.jaku.parser.AppsParser;
import com.jaku.parser.DeviceParser;
import com.jaku.parser.IconParser;
import com.jaku.parser.PlayerParser;
import com.jaku.request.*;

public class QueryRequests {
	
	private QueryRequests() {
		
	}
	
	@SuppressWarnings("unchecked")
	public static final List<Channel> queryAppsRequest(String url) throws IOException {
		QueryAppsRequest queryAppsRequest = new QueryAppsRequest(url);
		
		JakuRequest request = new JakuRequest(queryAppsRequest, new AppsParser());
		JakuResponse response = request.send();
		
		return (List<Channel>) response.getResponseData();
	}
	
	@SuppressWarnings("unchecked")
	public static final List<Channel> queryActiveAppRequest(String url) throws IOException {
		QueryActiveAppRequest queryActiveAppRequest = new QueryActiveAppRequest(url);
		
		JakuRequest request = new JakuRequest(queryActiveAppRequest, new AppsParser());
		JakuResponse response = request.send();
		
		return (List<Channel>) response.getResponseData();
	}
	
	public static final Device queryDeviceInfo(String url) throws IOException {
		QueryDeviceInfoRequest queryActiveAppRequest = new QueryDeviceInfoRequest(url);
		
		JakuRequest request = new JakuRequest(queryActiveAppRequest, new DeviceParser());
		JakuResponse response = request.send();
		
		return (Device) response.getResponseData();
	}
	
	public static final byte[] queryIconRequest(String url, String appId) throws IOException {
		QueryIconRequest queryActiveAppRequest = new QueryIconRequest(url, appId);
		
		JakuRequest request = new JakuRequest(queryActiveAppRequest, new IconParser());
		JakuResponse response = request.send();
		
		return ((ByteArrayOutputStream) response.getResponseData()).toByteArray();
	}

	public static final Player queryMediaPlayer(String url) throws IOException {
		QueryMediaPlayerRequest queryMediaPlayerRequest = new QueryMediaPlayerRequest(url);

		JakuRequest request = new JakuRequest(queryMediaPlayerRequest, new PlayerParser());
		JakuResponse response = request.send();

		return (Player) response.getResponseData();
	}
}
