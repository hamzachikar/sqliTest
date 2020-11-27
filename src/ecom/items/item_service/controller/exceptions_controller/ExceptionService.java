package ecom.items.item_service.controller.exceptions_controller;

import ecom.items.item.factory.factory_item.Item;

import java.util.Map;

public interface ExceptionService {
    void order(Map<String, Item> machines, Map<String, Item> capsules);
    void voucher(String code);

    boolean hasErrors();

    String errors();
}
