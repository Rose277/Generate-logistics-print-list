import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import java.awt.image.BufferedImage;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BarCode {
    public static void Bar(String msg,String name)
    {
        String path = "F:/"+name+".png";
        int height = 160;
        double width = UnitConv.in2mm(2.0f / height);
        File file = new File(path);
        OutputStream out;
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Code39Bean c39 = new Code39Bean();
        // 设置属性
        c39.setModuleWidth(width);
        c39.setWideFactor(2);
        String format = "image/png";
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, format, height, BufferedImage.TYPE_BYTE_BINARY,
                false, 0);
        // 生成图片
        c39.generateBarcode(canvas, msg);
        try {
        // 关闭流
            canvas.finish();
            System.out.println("ok...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }


}
