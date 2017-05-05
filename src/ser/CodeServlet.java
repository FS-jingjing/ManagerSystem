package mil.jtaspect.ser;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/yzcode")
public class CodeServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		request.setCharacterEncoding("utf-8");
		//随机对象
		Random r=new Random();
		//1、创建画板 new BufferedImage(宽，高，BufferedImage.颜色类型);
		//导包java.awt
		BufferedImage img=new BufferedImage(120,40,BufferedImage.TYPE_INT_RGB);
		//2、创建画笔 导包 java.awt 由画板获取 画板.getGraphics();
		Graphics g=img.getGraphics();
		//3、为画笔选颜色 创建一个Color对象new Color(int red,int green,int blue)
		//画笔.setColor(Color color);
		g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		//4、为画板画背景颜色 颜色是由画笔画上去的
		g.fillRect(0, 0, 120, 40);
		//5、生成随机字符
		String newstr=getString(5);
		//绑定到session
		HttpSession session=request.getSession();
		session.setAttribute("str", newstr);
		//6、设置验证码颜色
		g.setColor(new Color(255,255,255));
		//设置字体风格
		g.setFont(new Font("SAnsSerif",Font.BOLD|Font.ITALIC,30));
		//7、生成验证码字符
		g.drawString(newstr, 10, 30);
		//8、修改画笔颜色，生成干扰线
		g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		for(int i=0;i<5;i++){
			g.drawLine(r.nextInt(120), r.nextInt(40), r.nextInt(120), r.nextInt(40));
		}
		//9、获取输出流，并输出到浏览器
		ServletOutputStream sos=response.getOutputStream();
		javax.imageio.ImageIO.write(img, "JPEG", sos);	
	}
	public String getString(int num){
		Random r=new Random();
		String newstr="";
		String str="ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for(int i=0;i<num;i++){
			newstr+=str.charAt(r.nextInt(str.length()));
		}
		return newstr;
	}

}
