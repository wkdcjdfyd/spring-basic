package com.ryong.core;

import com.ryong.core.discount.DiscountPolicy;
import com.ryong.core.discount.FixDiscountPolicy;
import com.ryong.core.discount.RateDiscountPolicy;
import com.ryong.core.member.MemberRepository;
import com.ryong.core.member.MemberService;
import com.ryong.core.member.MemberServiceImpl;
import com.ryong.core.member.MemoryMemberRepository;
import com.ryong.core.order.OrderService;
import com.ryong.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    @Bean
    public MemberService memberService(){
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
