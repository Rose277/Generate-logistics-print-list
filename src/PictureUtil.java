import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class DrawDemo {

    public void Draw(Info info) throws Exception {
        //得到图片缓冲区
        BufferedImage bi = new BufferedImage(443, 649, BufferedImage.TYPE_INT_RGB);//INT精确度达到一定,RGB三原色，高度649,宽度443
        //得到它的绘制环境(这张图片的笔)
        Graphics2D g2 = (Graphics2D) bi.getGraphics();
        g2.fillRect(0, 0, 443, 649);//填充一个矩形 左上角坐标(0,0),宽70,高150;填充整张图片
        //设置颜色
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 443, 649);//填充整张图片(其实就是设置背景颜色)

        g2.setColor(Color.BLACK);
        g2.drawRect(0, 0, 443 - 1, 649 - 1); //画边框
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.setFont(new Font("微软雅黑", Font.ITALIC, 20)); //设置字体:字体、字号、大小
        g2.setColor(Color.BLACK);//设置背景颜色
        g2.drawString("国际件", 350, 35);
        g2.drawString("送达", 25, 90);
        g2.drawString("地址:", 25, 116);
        g2.drawString("集包地:" + info.getSetPackageAddress(), 25, 150);



        g2.setFont(new Font("微软雅黑", Font.ITALIC, 24)); //设置字体:字体、字号、大小
        g2.setColor(Color.BLACK);//设置背景颜色
        g2.drawString(info.getOrderNumber(), 90, 180);

        BarCode.Bar(info.getTrackingNumber(),"bar");
        BarCode.Bar(getTime(),"time");
        QRCodeUtils.encode(info.getTrackingNumber(),"F:/shunfeng.png","F:/liunn.png",true);
        paint(g2,bi,"bar",200,190,200,35);
        paint(g2,bi,"bar",18,325,200,35);
        paint(g2,bi,"time",100,265,300,35);
        paint(g2,bi,"shunfeng",300,325,60,40);
        paint(g2,bi,"liunn",300,480,130,130);

        g2.setFont(new Font("微软雅黑", Font.ITALIC, 12)); //设置字体:字体、字号、大小
        g2.setColor(Color.BLACK);//设置背景颜色

        g2.drawString("始发网点:" + info.getOriginatingSite(), 18, 18);
        g2.drawString("寄件人:" + info.getSender(), 18, 32);
        g2.drawString("寄件人电话:" + info.getSenderPhone(), 100, 32);
        g2.drawString("寄件公司:" + info.getShipperCompany(), 18, 46);
        g2.drawString("寄件人地址:" + info.getSenderAddress(), 18, 60);
        g2.drawString("收件人:" + info.getReceiver(), 90, 76);
        g2.drawString("收件人电话:" + info.getReceiverPhone(), 90, 90);
        g2.drawString("收件公司:" + info.getRecipientCompany(), 90, 104);
        g2.drawString("收件地址:" + info.getReceiverAddress(), 90, 118);
        g2.drawString("寄件人:" + info.getSender(), 18, 390);
        g2.drawString("寄件人电话:" + info.getSenderPhone(), 100, 390);
        g2.drawString("寄件公司:" + info.getShipperCompany(), 18, 410);
        g2.drawString("寄件人地址:" + info.getSenderAddress(), 18, 430);
        g2.drawString("收件人:" + info.getReceiver(), 18, 480);
        g2.drawString("收件人电话:" + info.getReceiverPhone(), 18, 520);
        g2.drawString("收件公司:" + info.getReceiverAddress(), 18, 560);
        g2.drawString("收件地址:" + info.getReceiverAddress(), 18, 600);
        g2.drawString("官方网址https://www.sf-express.com客服热线:95338", 0, 640);

        Stroke st = g2.getStroke();
        Stroke bs;
        bs = new BasicStroke(1,   BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,   0,new float[]{16,4},0);
        g2.setStroke(bs);
        g2.drawLine(0,230,443,230);
        g2.drawLine(0,260,443,260);
        g2.drawLine(0,320,443,320);
        g2.drawLine(0,370,443,370);
        g2.drawLine(0,460,443,460);
        g2.drawLine(0,620,300,620);
        g2.drawLine(300,460,300,649);
        g2.setStroke(st);

        g2.drawString("收件人/签收人", 18, 244);
        g2.drawString("签收日期:         年       月       日", 250, 244);
        g2.drawString("Name of Sign-off", 18, 258);
        g2.drawString("数量:"+info.getCount(), 18, 280);

        ImageIO.write(bi, "JPEG", new FileOutputStream("F:/a.jpg"));//保存图片 JPEG表示保存格式

    }
    public String getTime() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        String response = date.replaceAll("[[\\s-:punct:]]","");
        String now=BarCode.dateToStamp(date);
        int i=(int)(Math.random()*900)+100;
        String time=response+now.substring(0,3)+String.valueOf(i);
        return time;
    }
    public void paint(Graphics2D g2,BufferedImage bi,String name,int x,int y,int width,int height) throws IOException {
        File coverFile = new File("F:\\"+name+".png");
        BufferedImage cover = ImageIO.read(coverFile);
        g2=bi.createGraphics();
        g2.drawImage(cover, x, y, width, height, null);
    }
    public static void main(String[] args) throws Exception {
        Info info = new Info();
        info.setOriginatingSite("武汉市江夏区");
        info.setSender("俞明月");
        info.setSenderPhone("123456789");
        info.setShipperCompany("武汉纺织大学");
        info.setSenderAddress("武汉纺织大学");
        info.setReceiver("小月");
        info.setReceiverPhone("4567890123");
        info.setReceiverAddress("武汉大学菜鸟驿站");
        info.setRecipientCompany("武汉纺织大学");
        info.setSetPackageAddress("湖北省武汉市");
        info.setOrderNumber("180-E069-000");
        info.setCount("3.6");
        info.setTrackingNumber("7700000068784");
        DrawDemo drawDemo = new DrawDemo();
        drawDemo.Draw(info);
    }

}

