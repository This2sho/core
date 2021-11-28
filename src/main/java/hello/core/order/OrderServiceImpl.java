package hello.core.order;

import hello.core.discount.DisCountpolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DisCountpolicy disCountpolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DisCountpolicy disCountpolicy) {
        this.memberRepository = memberRepository;
        this.disCountpolicy = disCountpolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = disCountpolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
