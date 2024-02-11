package com.abijit.droolspoc.util;

import java.util.List;

public class Constants {
    public static final List<String> RULES_FILES_PATH_LIST = List.of("rules/drl/rules.drl",
            "rules/single/rules-that-return-single-item.drl.xlsx",
            "rules/single/rules-that-return-single-item-with-subObject.drl.xlsx",
            "rules/list/rules-that-return-list.drl.xlsx");
    public static final List<String> EXCEL_FILE_EXTENSION_LIST = List.of(".xls", ".xlsx");
    Constants() {
        throw new UnsupportedOperationException("This is a utility class.");
    }
}
