package com.tranquyet.controller;

import com.tranquyet.dto.MenuItemDto;
import com.tranquyet.dto.ProductItemDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupExample {
    public static void main(String[] args) throws Exception {
        // Fetch and parse HTML from a URL
        final String XFILTER_URL = "https://xfilter.vn";
        Document doc = Jsoup.connect(XFILTER_URL).get();

        // Get the title of the page
        String title = doc.title();
        System.out.println("Title: " + title);
        String classContentMain = "submenu__item--main";
        String text = "";
        String parContent = "";

        Elements elements = doc.getElementsByClass("submenu__item");
        for (Element submenuItem : elements) {
            MenuItemDto menuItemDto = new MenuItemDto();
            // Get class name
            String classNameTxt = submenuItem.attr("class");
            menuItemDto.setClassName(classNameTxt);
            // Find the <a> tag inside submenuItem
            Element linkElement = null;
            try {
                linkElement = submenuItem.getElementsByClass("link").first();
            } catch (Exception e) {
                // No link found
            }
            if (linkElement != null) {
                text = linkElement.attr("title").trim();
//                String text = linkElement.get.trim();
                String link = XFILTER_URL + linkElement.attr("href");
                menuItemDto.setContent(text);
                menuItemDto.setUrl(link);
            }
            // Determine if it is PARENT or CHILD
            if (classNameTxt.contains(classContentMain)) {
                menuItemDto.setObjType("PARENT");
                parContent = text;
                menuItemDto.setParContent(parContent);
                if(menuItemDto.getParContent().equals("SUZUKI")){
                    getProducts(menuItemDto);
                }
            } else {
                menuItemDto.setObjType("CHILD");
                menuItemDto.setParContent(parContent);
                getProducts(menuItemDto);
            }

        }

    }
    public static void getProducts (MenuItemDto item) throws IOException {
        // Fetch and parse HTML from a URL
        Element linkElement = null;

        Element prodInfoEl = null;
        Element priceEl = null;
        String linkItems = item.getContent();
        Document doc = Jsoup.connect(item.getUrl()).get();
        Elements elements = doc.getElementsByClass("item_product_main");
        for (Element submenuItem : elements) {
            ProductItemDto productItemDto = new ProductItemDto();
            prodInfoEl = submenuItem.getElementsByClass("product-info").first();
            linkElement = prodInfoEl.getElementsByClass("link").first();
            priceEl = prodInfoEl.getElementsByClass("price").first();
            String classNameTxt = linkElement.attr("title");
            String prodUrl = "https://xfilter.vn"+linkElement.attr("href");
            double price = Double.valueOf(priceEl.text().replace("₫", "").replace(",", ""));
            productItemDto.setUrl(prodUrl);
            productItemDto.setPrice(price);
            productItemDto.setName(classNameTxt);
            productItemDto.setLinkItem(linkItems);
            productItemDto.setParItem(item.getParContent());
            System.out.println("-->"+productItemDto);
        }
    }
}