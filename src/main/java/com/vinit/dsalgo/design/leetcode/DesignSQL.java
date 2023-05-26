package com.vinit.dsalgo.design.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DesignSQL {

    class SQL {
        class Table{

            int lastId = 0;
            int columns;
            Map<Integer, String[]> table = new LinkedHashMap<>();

            public Table(int columns){
                this.columns = columns;
            }
        }

        Map<String, Table> map = new HashMap<>();


        public SQL(List<String> names, List<Integer> columns) {

            for(int i = 0; i < names.size(); i++){
                map.put(names.get(i), new Table(columns.get(i)));
            }
        }

        public void insertRow(String name, List<String> row) {

            String[] newRow = new String[row.size()];
            for(int i = 0; i < newRow.length; i++){
                newRow[i] = row.get(i);
            }

            Table target = map.get(name);
            target.table.put(target.lastId + 1, newRow);
            target.lastId++;

        }

        public void deleteRow(String name, int rowId) {
            Table target = map.get(name);
            target.table.remove(rowId);

        }

        public String selectCell(String name, int rowId, int columnId) {

            Table target = map.get(name);
            return target.table.get(rowId)[columnId - 1];

        }
    }
}
