import React, { Component } from "react";
import { Container, Form, Button, Row, Col } from 'react-bootstrap';

class Signup extends Component {

    constructor(props) {
        super(props);
        this.state = {
            email: "",
            password: "",
            firstName: "",
            lastName: ""
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    handleSubmit() {
        console.log('test');
        fetch('api/signup', {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(this.state)
        }).then(response => response.json())
            .then(data => this.setState({ members: data }));
    }

    render() {
        return (
            <div>
                <Container fluid>
                    <Form onSubmit={this.handleSubmit}>
                        <Row>
                            <Form.Group as={Col} md="4" controlId="formBasicEmail">
                                <Form.Label>Email address</Form.Label>
                                <Form.Control
                                    type="email"
                                    placeholder="Email"
                                    name="email"
                                    value={this.state.email}
                                    onChange={this.handleChange}
                                />
                                {this.state.email}
                            </Form.Group>
                        </Row>
                        <Row>
                            <Form.Group as={Col} md="4" controlId="formBasicPassword">
                                <Form.Label>Password</Form.Label>
                                <Form.Control
                                    // required
                                    type="password"
                                    placeholder="Password"
                                    name="password"
                                    value={this.state.password}
                                    onChange={this.handleChange}
                                />
                            </Form.Group>
                        </Row>
                        <Row>
                            <Form.Group as={Col} md="4" controlId="validationCustom01">
                                <Form.Label>First name</Form.Label>
                                <Form.Control
                                    // required
                                    type="text"
                                    placeholder="First name"
                                    name="firstName"
                                    value={this.state.firstName}
                                    onChange={this.handleChange}
                                />
                                <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                            </Form.Group>
                        </Row>
                        <Row>
                            <Form.Group as={Col} md="4" controlId="validationCustom02">
                                <Form.Label>Last name</Form.Label>
                                <Form.Control
                                    // required
                                    type="text"
                                    placeholder="Last name"
                                    name="lastName"
                                    value={this.state.lastName}
                                    onChange={this.handleChange}
                                />
                                <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                            </Form.Group>
                        </Row>
                        <Form.Group className="mb-3">
                            <Form.Check
                                // required
                                label="Agree to terms and conditions"
                                feedback="You must agree before submitting."
                                feedbackType="invalid"
                            />
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>
                </Container>
            </div>
        );
    }
}
export default Signup;