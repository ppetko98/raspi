package app.app.controlador;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class LedController {

    private static GpioPinDigitalOutput pin;

    @RequestMapping("/")
    public String hola(){
        return "Hello world";
    }

    @RequestMapping("/toggle")
    public String light(){
        if (pin==null) {
            GpioController gpioController = GpioFactory.getInstance();
            pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "LED1", PinState.LOW);
        }

        pin.toggle();
        return "OK";
    }

}
