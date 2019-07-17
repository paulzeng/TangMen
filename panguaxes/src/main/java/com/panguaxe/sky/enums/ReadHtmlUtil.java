package com.panguaxe.sky.enums;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public enum ReadHtmlUtil {

    INTERFACE;

    public Document parse(String url) {
        try {
            return Jsoup.parse(new File(url), "UTF-8");
        } catch (IOException e) {
            log.info("文件读取失败！");
            e.printStackTrace();
        }
        return null;
    }

    public Set<Element> getSetByTag(org.jsoup.nodes.Document document, String tag) {
        Elements elements = document.getElementsByTag(tag);
        return new HashSet<>(elements);
    }

    public List<String> getListByTag(Element element, String tag) {
        Elements elements = element.getElementsByTag(tag);
        return elements.stream().map(Element::text).collect(Collectors.toList());
    }
}
