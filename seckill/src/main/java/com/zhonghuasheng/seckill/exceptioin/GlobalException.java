package com.zhonghuasheng.seckill.exceptioin;

import com.zhonghuasheng.seckill.common.CodeMsg;

public class GlobalException extends RuntimeException {

    private CodeMsg cm;

    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }
}
