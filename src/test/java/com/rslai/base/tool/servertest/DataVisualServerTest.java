package com.rslai.base.tool.servertest;

import com.rslai.base.tool.servertest.model.Operation;
import org.junit.runner.RunWith;


@RunWith(ServerTest.class)

@ServerTest.Options(
        testcase = "testcase/*.xml",
        service = {"service/service_tt.xml"},
        operation = Operation.CLEAR_INSERT,
        dsl={},
        //tags = { "fast", "normal", "exp"})
        tags = {"normal"})
public class DataVisualServerTest {

}

