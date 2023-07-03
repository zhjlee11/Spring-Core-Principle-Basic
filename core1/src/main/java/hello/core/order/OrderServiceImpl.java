package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //final이 붙은 모든 필드를 대입시켜주는 생성자를 자동 생성한다.
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    /*
    * DiscountPolicy에 특정한 구현체를 넣어주는 순간 구현체가 아닌 다른 것을 받기에 DIP 위반,
    * 고정할인정책에서 비율할인정책으로 바꿀 때 처럼 코드에 수정을 하는 순간 OCP 위반이다.
    *
    * 따라서, Interface만 넣고, 다른 무언가가 구현체를 "대신" 생성해서 넣어주어야 한다.
    *
    * AppConfig라는 "구성 객체를 생성 및 연결"하는 클래스를 별도로 만들어준다.
    *
    * */

    //생성자를 통한 "생성자 주입"
    @Autowired //생성자가 하나면 Autowired 생략 가능
    //위의 @RequiredArgsConstructor가 아래 생성자를 대신 생성해준다.
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
