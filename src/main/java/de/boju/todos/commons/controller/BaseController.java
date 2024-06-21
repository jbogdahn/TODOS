package de.boju.todos.commons.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(BaseController.BASE_PATH)
public abstract class BaseController {
    public static final String BASE_PATH = "/api/v1";
}
