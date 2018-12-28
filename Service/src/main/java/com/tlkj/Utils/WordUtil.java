package com.tlkj.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tlkj.CommonUtils.StringEx;
import org.apache.poi.xwpf.usermodel.*;


public class WordUtil {
    private static Logger log = LoggerFactory.getLogger(WordUtil.class);

    public static Boolean ExportPDF(String cTemplate, String cPDFName, Map<String, Object> objMap) {
        String cDocName = cPDFName.replace(".pdf", ".docx");
        File f = new File(cDocName);
        if (f.exists()) {
            try {
                f.delete();
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }

        if (ExportWord(cTemplate, cDocName, objMap)) {
            log.info(cDocName + "Word生成成功！");
            if (Word2Pdf(cDocName, cPDFName)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean ExportWord(String cTemplate, String cExportFileName, Map<String, Object> objMap) {
        File f = new File(cExportFileName);
        if (f.exists()) {
            try {
                f.delete();
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }
        OutputStream outf = null;
        XWPFDocument doc;
        InputStream inStream = null;
        try {
            inStream = Files.newInputStream(Paths.get(cTemplate));
            doc = new XWPFDocument(inStream);
            Iterator<XWPFParagraph> itPara = doc.getParagraphsIterator();
            while (itPara.hasNext()) {
                XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
                List<XWPFRun> runs = paragraph.getRuns();
                for (int i = 0; i < runs.size(); i++) {
                    String cStr = runs.get(i).getText(runs.get(i).getTextPosition());
                    for (Map.Entry<String, Object> entry : objMap.entrySet()) {
                        String cFieldName = entry.getKey();
                        String cFieldValue = StringEx.getStr(entry.getValue());
                        cStr = cStr.replace("{" + cFieldName + "}", cFieldValue);
                    }
                    runs.get(i).setText(cStr, 0);
                }
            }

            Iterator<XWPFTable> itTable = doc.getTablesIterator();
            while (itTable.hasNext()) {
                XWPFTable table = (XWPFTable) itTable.next();
                int rcount = table.getNumberOfRows();
                for (int i = 0; i < rcount; i++) {
                    XWPFTableRow row = table.getRow(i);
                    List<XWPFTableCell> cells = row.getTableCells();
                    for (XWPFTableCell cell : cells) {
                        String cellTextString = cell.getText();
                        for (Map.Entry<String, Object> entry : objMap.entrySet()) {
                            String cFieldName = entry.getKey();
                            String cFieldValue = StringEx.getStr(entry.getValue());
                            if (cellTextString.contains(cFieldName))
                                cellTextString = cellTextString.replace("{" + cFieldName + "}", cFieldValue);
                        }
                        cell.removeParagraph(0);
                        cell.setText(cellTextString);
                    }
                }
            }

            outf = new FileOutputStream(f);
            doc.write(outf);

            return true;
        } catch (Exception ex) {
            log.error("ExportWord:" + ex.getMessage());
            return false;
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (Exception ex) {
                    log.error(ex.getMessage());
                }
            }

            if (outf != null) {
                try {
                    outf.close();
                } catch (Exception ex) {
                    log.error(ex.getMessage());
                }
            }
        }
    }

    public static Boolean Word2Pdf(String cDOCName, String cPDFName) {
        XWPFDocument doc;
        InputStream inStream = null;
        OutputStream out = null;
        try {
            inStream = Files.newInputStream(Paths.get(cDOCName));
            doc = new XWPFDocument(inStream);
            PdfOptions options = PdfOptions.create();
            out = Files.newOutputStream(Paths.get(cPDFName));
            PdfConverter.getInstance().convert(doc, out, options);
            return true;
        } catch (Exception ex) {
            log.error("DOC2PDF:" + ex.getMessage());
            return false;
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (Exception ex) {
                    log.error(ex.getMessage());
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (Exception ex) {
                    log.error(ex.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        String docPath = "D:\\20182.docx";
        String pdfPath = "D:\\2018.pdf";
        Word2Pdf(docPath, pdfPath);
    }
}
