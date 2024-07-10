package game.other;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int width = 50;
		int height = 25;
		// 创建BufferedImage对象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取Graphics对象
		Graphics g = image.getGraphics();
		g.setColor(Color.PINK);
		g.fillRect(0, 0, width - 1, height);
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, width - 1, height - 1);

		String str = "1234567890";
		Random ran = new Random();
		String str1 = "";
		for (int i = 1; i <= 4; i++) {
			int index = ran.nextInt(str.length());
			char ch = str.charAt(index);
			str1 = str1 + ch;
			g.setColor(Color.BLACK);
			g.drawString(ch + "", width / 5 * i, height / 2);
		}

		// 将验证码字符保存到session中
		request.getSession().setAttribute("checkcode_session", str1);

		// 绘制干扰线
		g.setColor(Color.gray);
		for (int i = 0; i < 3; i++) {
			int x1 = ran.nextInt(width);
			int x2 = ran.nextInt(width);
			int y1 = ran.nextInt(height);
			int y2 = ran.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		g.dispose();// 回收

		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}
