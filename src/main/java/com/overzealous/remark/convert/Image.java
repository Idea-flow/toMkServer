package com.overzealous.remark.convert;


import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/**
 * Handles img tags.
 * @author Phil DeJarnett
 */
public class Image extends AbstractNodeHandler {

    @Override
    public void handleNode(NodeHandler parent, Element node, DocumentConverter converter) {
            String url = converter.getCleaner().cleanUrl(node.attr("src"));
            if (StringUtils.isNotBlank(url)) {
                String alt = node.attr("alt");
                converter.getOutput().printf("![%s](%s)", alt, url);
            }

        }
}
