package cn.xxx.ssm.controller.convert;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

public class CustomDateConverter implements Converter<String, Date>{

    @Override
    public Date convert(String source) {
        //实现将日期字符串转换成日期类型（格式是yyyy-MM-dd HH:mm:ss）
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //如果转换成功
            return format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //如果绑定失败
        return null;
    }
}