package com.wpl.tomarkdownserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebSiteContent {
    private String title;
    private String content;

}
