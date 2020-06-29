import com.aditya.myspringboot.controller.FirstController
import com.aditya.myspringboot.service.FirstService
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

class FirstControllerUnitSpec extends Specification{


    def firstController = new FirstController(firstService: Mock(FirstService))

    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

    def "first sayHello"(){
        when:
            def response = firstController.sayHello("Truck")
        then:
            1 * firstController.firstService.getCar("Truck") >> "Driving truck"
            response == "Driving truck"

    }

}