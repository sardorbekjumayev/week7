#include <iostream>
using namespace std;



    //Restourant Order Project


/*
int calculateTotal(int itemNum, int quantity) {
    const int pizza = 10;
    const int burger = 8;
    const int salad = 5;

    switch (itemNum) {
        case 1: return pizza * quantity;
        case 2: return burger * quantity;
        case 3: return salad * quantity;
        default: return 0;
    }
}

int main() {
    int option, quantity;
    int total = 0;
    char select = 'y';

    do {
        cout << "RESTAURANT MENU\n";
        cout << "-------------------" << endl;
        cout << "1. Pizza  - $10\n2. Burger - $8\n3. Salad  - $5\n";
        cout << "Select item number and quantity: ";
        cin >> option >> quantity;

        int cost = calculateTotal(option, quantity);
        if (cost == 0) {
            cout << "Invalid option!\n";
        } else {
            total += cost;
        }

        cout << "Continue? (y/n): ";
        cin >> select;
        cout << endl;
    } while (select == 'y' || select == 'Y');

    cout << "Total bill: $" << total << endl;
    return 0;
}
*/



    //Parking Fee Project


/*
int calculateTotal(int hours) {

    if (hours > 0 and hours <= 2) {
        return 0;
    }else if (hours > 2 and hours <= 5) {
        return hours*2;
    }else if (hours > 6) {
        return hours*5;
    }
}

int main() {

    int hour;
    int total = 0;
    char select = 'y';

    while (select == 'y' || select == 'Y') {

        cout << "Enter Parking Hours: ";
        cin >> hour;

        int cost = calculateTotal(hour);
        if (cost == 0) {
            cout << "Free";
        } else {
            total += cost;
        }

        cout << "Continue? (y/n): ";
        cin >> select;
        cout << endl;
    }

    cout << "Total Parking Fee: $" << total << endl;
    return 0;

}

*/



    //Ticket booking System Project


/*
int calculateTotal(int movieNum, int quantity) {
    const int movieA = 8;
    const int movieB = 10;
    const int movieC = 12;

    switch (movieNum) {
        case 1: return movieA * quantity;
        case 2: return movieB* quantity;
        case 3: return movieC * quantity;
        default: return 0;
    }
}

int main() {
    int option, quantity;
    int total = 0;
    char select = 'y';

    do {
        cout << "MOVIE NIGHT    \n";
        cout << "-------------------" << endl;
        cout << "1. Movie A  - $8\n2. Movie B - $10\n3. Movie C  - $12\n";
        cout << "Select Movie number and ticket quantity: ";
        cin >> option >> quantity;

        int cost = calculateTotal(option, quantity);
        if (cost == 0) {
            cout << "Invalid option!\n";
        } else {
            total += cost;
        }

        cout << "Continue? (y/n): ";
        cin >> select;
        cout << endl;
    } while (select == 'y' || select == 'Y');

    cout << "Total Tickets cost: $" << total << endl;
    return 0;
}

*/



