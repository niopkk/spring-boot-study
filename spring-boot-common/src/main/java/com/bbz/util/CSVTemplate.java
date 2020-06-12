package com.bbz.util;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

/**
 * csvc文件操作接口
 */
public interface CSVTemplate {


    CSVFormat DEFAULT_CSV_FORMAT = CSVFormat.DEFAULT
            .withAllowMissingColumnNames()
            .withIgnoreEmptyLines()
            .withNullString("fadsdf")
            .withFirstRecordAsHeader();


    static CSVTemplate of(CSVFormat format) {
        return new CSVTemplate() {
            @Override
            public CSVFormat getFormat() {
                return format;
            }
        };
    }


    static CSVTemplate of() {
        return of(DEFAULT_CSV_FORMAT);
    }

    static CSVFormat getCassandraFormat() {
        return CSVFormat.DEFAULT
                .withDelimiter(',')
                .withQuote('\"')
                .withQuoteMode(QuoteMode.MINIMAL)
                .withEscape('\\');
    }

    default CSVFormat getFormat() {
        return DEFAULT_CSV_FORMAT;
    }


    default void process(Reader reader, Consumer<SafeCSVRecord> consumer) {
//        Logger logger = Logger.of(getClass());
        CSVParser parser;
        try {
            parser = new CSVParser(reader, getFormat());
        } catch (IOException ex) {
            throw new RuntimeException("读取CSV文件失败", ex);
        }
        Iterator<CSVRecord> iterator = parser.iterator();
        while (iterator.hasNext()) {
            try {
                CSVRecord record = iterator.next();
                SafeCSVRecord safe = SafeCSVRecord.of(record);
                /**
                 * 判断是否是空白行
                 */
                if (Streams.of(record.toMap().values()).anyMatch(Strings::isNotBlank)) {
                    consumer.accept(safe);
                }
            } catch (Exception ex) {
//                logger.warn("处理CSV数据失败", ex);
            }
        }
    }


    interface SafeCSVRecord {


        static SafeCSVRecord of(CSVRecord record) {
            return new SafeCSVRecord() {
                @Override
                public String get(int index) {
                    return record.get(index);
                }

                @Override
                public String get(String colname) {
                    boolean mapped = record.isMapped(colname);
                    return mapped ? record.get(colname) : Strings.EMPTY;
                }

                @Override
                public long getCharacterPosition() {
                    return record.getCharacterPosition();
                }

                @Override
                public String getComment() {
                    return record.getComment();
                }

                @Override
                public long getRecordNumber() {
                    return record.getRecordNumber();
                }


                @Override
                public Map<String, String> toMap() {
                    return record.toMap();
                }
            };
        }

        String get(int index);


        String get(String colname);

        long getCharacterPosition();

        String getComment();


        long getRecordNumber();

        Map<String, String> toMap();
    }

}
