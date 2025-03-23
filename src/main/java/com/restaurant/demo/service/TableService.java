package com.restaurant.demo.service;

import com.restaurant.demo.model.Table;
import com.restaurant.demo.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    // Get Available Tables
    public List<Table> getAvailableTables() {
        return tableRepository.findByIsOccupiedFalse();
    }

    // Assign Table
    public Table assignTable(int tableNumber) {
        Table table = tableRepository.findByTableNumber(tableNumber)
                .orElseThrow(() -> new RuntimeException("Table not found"));
        if (!table.isOccupied()) {
            table.setOccupied(true);
            return tableRepository.save(table);
        }
        throw new RuntimeException("Table is already occupied");
    }

    // Free a Table (Mark as Available)
    public Table freeTable(int tableNumber) {
        Table table = tableRepository.findByTableNumber(tableNumber)
                .orElseThrow(() -> new RuntimeException("Table not found"));
        table.setOccupied(false);
        return tableRepository.save(table);
    }

    // Add New Table
    public Table addTable(Table table) {
        return tableRepository.save(table);
    }
}
