package com.company;

import com.company.interfaces.Editable;
import com.company.interfaces.Printable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

public class CustomArrayList<T extends Printable & Editable<T>> extends ArrayList<T> {

    private int position;
    private Supplier<T> supplier;

    {
        this.position = 0;
    }

    public CustomArrayList(Supplier<T> supplier) {
        position = 0;
        this.supplier = supplier;
    }

    public CustomArrayList(Collection<? extends T> c, Supplier<T> supplier) {
        super(c);
        this.supplier = supplier;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public T current(boolean... printMessage) {
        boolean toPrint = false;
        if (printMessage.length > 0) {
            toPrint = printMessage[0];
        }

        if (isEmpty(toPrint)) {
            return null;
        } else {
            this.get(position).printContent();
            return this.get(position);
        }
    }

    public T next(boolean... printMessage) {

        boolean toPrint = false;
        if (printMessage.length > 0) {
            toPrint = printMessage[0];
        }

        if (!isEmpty(toPrint)) {
            if (position < size() - 1) {
                position++;
                this.get(position).printContent();
            } else {
                this.get(position).printAtLastPositionMessage();
            }
        }
        return this.get(position);
    }

    public T previous(boolean... printMessage) {
        boolean toPrint = false;
        if (printMessage.length > 0) {
            toPrint = printMessage[0];
        }

        if (!isEmpty(toPrint)) {
            if (position > 0) {
                position--;
                this.get(position).printContent();
                return this.get(position);
            } else {
                this.get(position).printAtFirstPositionMessage();
            }
        }
        return null;
    }

    public T first() {
        if (!isEmpty()) {
            position = 0;
        }
        return this.get(position);
    }

    public T last() {
        if (!isEmpty()) {
            position = this.size() - 1;
        }
        return this.get(position);
    }

    public boolean isEmpty(boolean... printMessage) {
        boolean b = isEmpty();
        boolean toPrint = false;
        if (printMessage.length > 0) {
            toPrint = printMessage[0];
        }
        if (b && toPrint) {
            supplier.get().printEmptyMessage();
        }
        return b;
    }

    public Result<T> removeCurrent(boolean... saveToDatabase) throws Exception {
        Result<T> result = new Result<>();
        boolean toDB = false;
        if (saveToDatabase.length == 1) {
            toDB = saveToDatabase[0];
        } else if (saveToDatabase.length > 1) {
            throw new Exception("Too Many Arguments");
        }
        if (toDB) {
            result = this.get(position).delete();
        }
        this.remove(position);
        this.previous(saveToDatabase);
        return result;
    }
}
