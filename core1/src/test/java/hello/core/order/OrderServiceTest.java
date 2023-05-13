package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberid = 1L;
        Member member = new Member(memberid, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberid, "itemA", 10000);
        Assertions.assertEquals(order.getDiscountPrice(), 1000);
    }

}