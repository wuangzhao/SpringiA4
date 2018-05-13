package spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//将异常映射为HTTP状态404
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Spittle Not Found !")
public class SpittleNotFoundException extends RuntimeException {

}
