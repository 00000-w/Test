package com.coder.supermarket;

import com.coder.supermarket.controller.IndexController;
import com.coder.supermarket.db.DB;

public class MainApplication {
    public static void main(String[] args) {
        DB.init();
        IndexController.run();
    }
}
