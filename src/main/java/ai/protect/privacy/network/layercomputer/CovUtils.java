package ai.protect.privacy.network.layercomputer;

import java.util.List;

/**
 * 为2d的CNN提供一些公共基础方法，如维度转换
 * @author CodeGang
 * @since jdk1.8
 */
public class CovUtils {
    /**
     * 将输入数据从一维的形式，还原为二维多通道
     * @param data 输入数据
     * @param column 二维的列的大小
     * @param row  二维行的大小
     * @param paddingRow 需要填充的行数
     * @param paddingCol 需要填充的列数
     * @param channel 通道数
     * @return 二维多通道的数据
     */
    public static Object[][][] changeTo2D(List data,int column,int row, int paddingRow,int paddingCol,int channel){
        Object[][][] images = new Object[channel][row+2*paddingRow][column+2*paddingCol];
        for(int i =0;i<channel;i++){
            for (int r=0;r<row;r++){
                for (int c=0;c<column;c++){
                    images[i][paddingRow+r][paddingCol+c]=data.get(row*column*i+r*column+c);
                }
            }
        }
        return images;
    }

    /**
     * 从一个图像中获取一个块的数据
     * @param image 输入图像
     * @param block 装载块数据的列表
     * @param beginRow 块的起始行
     * @param beginColumn 块的起始行
     * @param blockRow 块的行大小
     * @param blockColumn 块的列大小
     */
    public static void get2dBlock(Object[][] image, List block, int beginRow, int beginColumn,int blockRow,int blockColumn) {
        for (int i = 0; i < blockRow; i++) {
            for (int j = 0; j < blockColumn; j++) {
                block.add(image[i+beginRow][j+beginColumn]);
            }
        }
    }


}
