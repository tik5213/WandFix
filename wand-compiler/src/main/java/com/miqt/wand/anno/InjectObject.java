package com.miqt.wand.anno;

public @interface InjectObject {
    //class name
    String value();

    ParentalEntrustmentLevel level()
            default ParentalEntrustmentLevel.NEVER;
}
