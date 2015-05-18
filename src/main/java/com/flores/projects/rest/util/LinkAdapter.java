package com.flores.projects.rest.util;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

/**
 * Taken from a StackOverflow post http://stackoverflow.com/questions/24968448/jax-rs-hateoas-using-jersey-unwanted-link-properties-in-json
 * to resolve a #toString() bug in the jersey-media-moxy library when creating JSON links.  One of these days
 * they'll get around to it...
 * 
 * @author Jason
 */
public class LinkAdapter extends XmlAdapter<LinkJaxb, Link> {

	@Override
	public Link unmarshal(LinkJaxb v) throws Exception {
		Link.Builder builder = Link.fromUri(v.getUri());
		for(Map.Entry<QName, Object>entry : v.getParams().entrySet()) {
			builder.param(entry.getKey().getLocalPart(), entry.getValue().toString());
		}
		return builder.build();
	}

	@Override
	public LinkJaxb marshal(Link v) throws Exception {
		Map<QName, Object> params = new HashMap<>();
		for(Map.Entry<String, String> entry : v.getParams().entrySet())
			params.put(new QName("", entry.getKey()), entry.getValue());
		return new LinkJaxb(v.getUri(), params);
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
