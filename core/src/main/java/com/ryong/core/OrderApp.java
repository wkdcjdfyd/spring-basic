package com.ryong.core;

import com.ryong.core.member.Grade;
import com.ryong.core.member.Member;
import com.ryong.core.member.MemberService;
import com.ryong.core.member.MemberServiceImpl;
import com.ryong.core.order.Order;
import com.ryong.core.order.OrderService;
import com.ryong.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
