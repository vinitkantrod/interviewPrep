package com.vinit.dsalgo.recursion.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class GetLowestCommonManager {

    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
    }

    public static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        int numOfImportantReports = 0;
        for (OrgChart directReports : manager.directReports) {
            OrgInfo reports = getOrgInfo(directReports, reportOne, reportTwo);
            if (reports.lowestCommonManager != null) return reports;
            numOfImportantReports += reports.numImportantReports;
        }
        if (manager == reportOne || manager == reportTwo)
            numOfImportantReports += 1;
        OrgChart lowestCommonManager = numOfImportantReports == 2 ? manager : null;
        return new OrgInfo(lowestCommonManager, numOfImportantReports);
    }

    static class OrgInfo {
        public OrgChart lowestCommonManager;
        public Integer numImportantReports;

        public OrgInfo(OrgChart l, Integer n) {
            this.lowestCommonManager = l;
            this.numImportantReports = n;
        }
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

    public static void main(String args[]) {

    }
}
