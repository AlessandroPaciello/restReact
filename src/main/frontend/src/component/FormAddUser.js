import React, {Component} from 'react';

class FormAddUser extends Component {

    constructor() {
        super();
        this.state = {
            firstName : "",
            lastName: "",
            number : 0,
            memo : "",
            date : ""

        }
    }

    onChangeState = (e) => {
        this.setState({ [e.target.name] : e.target.value})
    }
    addUser = (e) => {
        fetch("api/users", {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify(this.state)
        })
            .then(response => response.json())
            .catch(error => console.error(error))
        e.preventDefault();
    }
    render() {
        return (
            <form onSubmit={this.addUser}>
                <label>
                    nome:
                    <input type="text" name="firstName" value={this.state.firstName} onChange={this.onChangeState}/>
                </label><br/>
                <label>
                    cogome:
                    <input type="text" name="lastName" value={this.state.lastName} onChange={this.onChangeState}/>
                </label><br/>
                <label>
                    numero:
                    <input type="number" name="number" value={this.state.number} onChange={this.onChangeState}/>
                </label><br/>
                <label>
                    promemoria:
                    <input type="text" name="memo" value={this.state.memo} onChange={this.onChangeState}/>
                </label><br/>
                <label>
                    data:
                    <input type="date" name="date" value={this.state.date} onChange={this.onChangeState}/>
                </label><br/>
                <label>
                    invia:
                    <input type="submit" value="invia"/>
                </label><br/>
            </form>
        );
    }
}

export default FormAddUser;