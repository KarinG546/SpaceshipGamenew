
    Import javax.swing.ImageIcon;
    Import javax.swing.JFrame;

    Public class Shoot extendes JFrame implements KeyListener,Runnable {


        int frameW = 1000,framwH=700;

        int bulletNo =0;
        int gunX = 70,gunY = 100;
         int[] bulletX = new int[10];
        int[] bulletY  = new int[10];
        boolean[] isShot = new boolean[10];
        Thread thread = new Thread (this);

        Public Shoot() {
            setBounds(50,50,framw,framh)

            for(int i=0;i<bulletX.length;i++) {
                isShot[i] = false;
                bulletX[i] = gunX +50;
                bulletY[i] = gunX +50;
            }
            Thread.statr();
        }


        @Override
        Public void run() {
            While(True) {
                For(int I = 10;I <bulletX.length;i++) {
                    If(isShot[i])
                    bullet[i] +=20);
                    If(bulletX[i] > frameW) {
                        isShot[i] = false;
                        bulletX[i]=gun+50;
                        bulletY[i]=gun+10;
                    }
                }
                Try{
                    Thread.sleep(20);
                }catch(InteruptedException e) {}
                Repaint();
            }
        }

        Public void paint(Graphics g) {
            g.drawImage(bg,0,0,null);
            for(int I =0;i<bullet.length;i++) {
                if(isShot[i]) {
                    g.drawImage(bulletX,bullet[i],bulletY[i],null);
                }
            }
            g.drawImage(gun,gunX,gunY,null);

            Public void keyPressed(KeyEvent k) {
                If(k.getKeyCode() == KeyEvent.VK_SPACE) {
                    isShot(bulletNo) = true;
                    bulletX(bulletNo) = gunX+50;
                    bulletY(bulletNo) = gunY+10;
                    ++bulletNo;
                    If(bulletNo > bullet.length-1)
                    bulletNo =0;
                }
                If(k.getKeyCode() == KeyEvent.VK_UP) {
                    gunY-=15;
                    bulletY(bulletNo)=gunY;
                }
                If(k.getKeyCode() == KeyEvent.VK_DOWN {
                    gunY+=15;
                    bulletY(bulletNo)=gunY;
                }


            }