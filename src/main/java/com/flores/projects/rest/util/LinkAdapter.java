package com.flores.projects.rest.util;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

public class LinkAdapter extends XmlAdapter<LinkJaxb, Link> {

	@Override
	public Link unmarshal(LinkJaxb v) throws Exception {
		return null;
	}

	@Override
	public LinkJaxb marshal(Link v) throws Exception {
		return null;
	}	
}

class LinkJaxb {
	private URI uri;
	private Map<QName, Object> params;
	
	public LinkJaxb() {
		this(null, null);
	}
	
	public LinkJaxb(URI uri) {
		this(uri, null);
	}
	
	public LinkJaxb(URI uri, Map<QName, Object>params) {
		this.uri = uri;
		this.params = params != null ? params : new HashMap<QName, Object>();
	}
	
	@XmlAttribute(name = "href")
	public URI getUri() {
		return uri;
	}
	
	@XmlAnyAttribute
	public Map<QName, Object>getParams() {
		return params;
	}
	
	public void setUri(URI uri) {
		this.uri = uri;
	}
	
	public void setParams(Map<QName, Object> params) {
		this.params = params;
	}
}
