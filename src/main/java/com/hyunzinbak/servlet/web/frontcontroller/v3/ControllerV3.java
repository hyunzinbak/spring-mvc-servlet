package com.hyunzinbak.servlet.web.frontcontroller.v3;

import com.hyunzinbak.servlet.web.frontcontroller.ModelView;
import com.hyunzinbak.servlet.web.frontcontroller.MyView;
import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
