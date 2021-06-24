package com.heima.service;

import java.io.IOException;

public interface AccountService {

    Boolean transfer(Integer fromId,Integer toId,Float money) throws IOException;

}
