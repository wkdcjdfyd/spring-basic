package com.ryong.core.order;

import com.ryong.core.discount.DiscountPolicy;
import com.ryong.core.discount.FixDiscountPolicy;
import com.ryong.core.member.Member;
import com.ryong.core.member.MemberRepository;
import com.ryong.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
