package com.panguaxe.sky;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.panguaxe.sky.enums.ReadHtmlUtil;
import com.panguaxe.sky.land.mapper.BankCardBaseMapper;
import com.panguaxe.sky.land.model.BankCardBase;
import com.panguaxe.sky.land.service.IBankCardBaseService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName HtmlJsoupApplicationTests
 * @Description TODO :
 * @Author ：Panguaxe
 * @Date 2019/7/17 20:59
 * @Version V1.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlJsoupApplicationTests {

    @Autowired
    private BankCardBaseMapper bankCardBaseMapper;

    @Test
    public void contextLoads() {
        Document document = ReadHtmlUtil.INTERFACE.parse("C:/Users/Administration/Desktop/abc/bank.htm");
        Set<Element> elements = ReadHtmlUtil.INTERFACE.getSetByTag(Objects.requireNonNull(document), "tr");
        List<BankCardBase> bankCards = new ArrayList<>();
        elements.forEach(element -> {
            List<String> strings = ReadHtmlUtil.INTERFACE.getListByTag(element, "td");
            BankCardBase bcb = new BankCardBase();
            bcb.setBankName(strings.get(1));
            bcb.setBankAbbr(strings.get(2));
            bcb.setCardCode(strings.get(3));
            bcb.setCardName(strings.get(4));
            bcb.setCardNoLength(strings.get(5));
            bcb.setBinLength(strings.get(6));
            bcb.setCardBin(strings.get(7));
            bcb.setCardType(strings.get(8));
            bankCards.add(bcb);
        });
        Collections.sort(bankCards, new Comparator<BankCardBase>() {
            @Override
            public int compare(BankCardBase o1, BankCardBase o2) {
                return o1.getBankName().compareTo(o2.getBankName());
            }
        });
        for (BankCardBase bc : bankCards) {
            bankCardBaseMapper.insertSelective(bc);
        }
    }
}
