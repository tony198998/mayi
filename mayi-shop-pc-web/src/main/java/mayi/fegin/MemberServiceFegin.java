package mayi.fegin;

import com.mayi.api.service.MemberService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@Component
//@FeignClient("member")
public interface MemberServiceFegin extends MemberService {

}
