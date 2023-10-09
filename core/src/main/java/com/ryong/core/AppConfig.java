package com.ryong.core;

import com.ryong.core.discount.FixDiscountPolicy;
import com.ryong.core.member.MemberService;
import com.ryong.core.member.MemberServiceImpl;
import com.ryong.core.member.MemoryMemberRepository;
import com.ryong.core.order.OrderService;
import com.ryong.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
