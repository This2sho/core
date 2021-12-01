package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DisCountpolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final이 붙은 걸 가지고 생성자를 만들어준다.
//@Qualifier("mainDiscountPolicy")
public class OrderServiceImpl implements OrderService{

    private final  MemberRepository memberRepository;
    private final  DisCountpolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DisCountpolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    //    @Autowired(required = false) // 선택적 주입
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDisCountpolicy(DisCountpolicy disCountpolicy) {
//        this.disCountpolicy = disCountpolicy;
//    }

//    public OrderServiceImpl(MemberRepository memberRepository, DisCountpolicy disCountpolicy) {
//        this.memberRepository = memberRepository;
//        this.disCountpolicy = disCountpolicy;
//    }

//    @Autowired
//    public void init(MemberRepository memberRepository, DisCountpolicy disCountpolicy) {
//        this.disCountpolicy = new RateDiscountPolicy();
//        this.memberRepository = new MemoryMemberRepository();
//    }

}
